package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 001 : 01-10-2017.
 */
public class BaashaaText implements Parcelable {

    int id;
    String text;
    int imgType;
    int scriptId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScriptId() {
        return scriptId;
    }

    public void setScriptId(int scriptId) {
        this.scriptId = scriptId;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    protected BaashaaText(Parcel in) {
        id = in.readInt();
        scriptId = in.readInt();
        text = in.readString();
        imgType = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(scriptId);
        dest.writeString(text);
        dest.writeInt(imgType);
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaText> CREATOR = new Creator<BaashaaText>() {
        @Override
        public BaashaaText createFromParcel(Parcel in) {
            return new BaashaaText(in);
        }

        @Override
        public BaashaaText[] newArray(int size) {
            return new BaashaaText[size];
        }
    };
}