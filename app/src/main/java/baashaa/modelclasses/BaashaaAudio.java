package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 001 : 01-10-2017.
 */
public class BaashaaAudio implements Parcelable {


    int voiceId;
    @SerializedName("url")
    String voiceUrl;
    @SerializedName("id")
    int id;
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

    public int getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(int voiceId) {
        this.voiceId = voiceId;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public String getUrl() {
        return voiceUrl;
    }

    public void setUrl(String url) {
        this.voiceUrl = url;
    }



    protected BaashaaAudio(Parcel in) {
        voiceId = in.readInt();
        voiceUrl = in.readString();
        id = in.readInt();
        type = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(voiceId);
        dest.writeString(voiceUrl);
        dest.writeInt(id);
        dest.writeInt(type);
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaAudio> CREATOR = new Creator<BaashaaAudio>() {
        @Override
        public BaashaaAudio createFromParcel(Parcel in) {
            return new BaashaaAudio(in);
        }

        @Override
        public BaashaaAudio[] newArray(int size) {
            return new BaashaaAudio[size];
        }
    };
}