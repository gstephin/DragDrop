package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 001 : 01-10-2017.
 */
public class BaashaaImage implements Parcelable {
  /*  "id": null,
            "url": null,
            "type": "1"*/
    int id;
    int url;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public BaashaaImage() {
    }

    protected BaashaaImage(Parcel in) {
        id = in.readInt();
        url = in.readInt();
        type = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(url);
        dest.writeInt(type);
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaImage> CREATOR = new Creator<BaashaaImage>() {
        @Override
        public BaashaaImage createFromParcel(Parcel in) {
            return new BaashaaImage(in);
        }

        @Override
        public BaashaaImage[] newArray(int size) {
            return new BaashaaImage[size];
        }
    };
}