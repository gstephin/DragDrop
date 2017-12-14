package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 025 : 25-10-2017.
 */
public class BaashaaLanguage implements Parcelable {

    @SerializedName("lanId")
    int languageId;
    String name;
    String desc;
    int voiceId;
    String voiceUrl;
    int iconId;
    String iconUrl;
    @SerializedName("lanCode")
    String languageCode;
    @SerializedName("ct")
    String createdTime;
    @SerializedName("lt")
    String updatedTime;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public BaashaaLanguage() {
    }

    protected BaashaaLanguage(Parcel in) {
        languageId = in.readInt();
        name = in.readString();
        desc = in.readString();
        voiceId = in.readInt();
        voiceUrl = in.readString();
        iconId = in.readInt();
        iconUrl = in.readString();
        languageCode = in.readString();
        createdTime = in.readString();
        updatedTime = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(languageId);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(voiceId);
        dest.writeString(voiceUrl);
        dest.writeInt(iconId);
        dest.writeString(iconUrl);
        dest.writeString(languageCode);
        dest.writeString(createdTime);
        dest.writeString(updatedTime);
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaLanguage> CREATOR = new Creator<BaashaaLanguage>() {
        @Override
        public BaashaaLanguage createFromParcel(Parcel in) {
            return new BaashaaLanguage(in);
        }

        @Override
        public BaashaaLanguage[] newArray(int size) {
            return new BaashaaLanguage[size];
        }
    };
}
