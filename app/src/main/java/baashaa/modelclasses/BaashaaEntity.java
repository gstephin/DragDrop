package baashaa.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 007 : 07-12-2017.
 */
public class BaashaaEntity implements Parcelable {
    int entityId;
    int parentId;
    String entityName;
    String entityDescription;
    String createdTime;
    String lastUpdatedTime;
    String languageCode;
    List<BaashaaAudio> audios;
    List<BaashaaImage> images;

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public List<BaashaaAudio> getAudios() {
        return audios;
    }

    public void setAudios(List<BaashaaAudio> audios) {
        this.audios = audios;
    }

    public List<BaashaaImage> getImages() {
        return images;
    }

    public void setImages(List<BaashaaImage> images) {
        this.images = images;
    }

    public BaashaaEntity() {
    }

    protected BaashaaEntity(Parcel in) {
        entityId = in.readInt();
        parentId = in.readInt();
        entityName = in.readString();
        entityDescription = in.readString();
        createdTime = in.readString();
        lastUpdatedTime = in.readString();
        languageCode = in.readString();
        if (in.readByte() == 0x01) {
            audios = new ArrayList<BaashaaAudio>();
            in.readList(audios, BaashaaAudio.class.getClassLoader());
        } else {
            audios = null;
        }
        if (in.readByte() == 0x01) {
            images = new ArrayList<BaashaaImage>();
            in.readList(images, BaashaaImage.class.getClassLoader());
        } else {
            images = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(entityId);
        dest.writeInt(parentId);
        dest.writeString(entityName);
        dest.writeString(entityDescription);
        dest.writeString(createdTime);
        dest.writeString(lastUpdatedTime);
        dest.writeString(languageCode);
        if (audios == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(audios);
        }
        if (images == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(images);
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<BaashaaEntity> CREATOR = new Creator<BaashaaEntity>() {
        @Override
        public BaashaaEntity createFromParcel(Parcel in) {
            return new BaashaaEntity(in);
        }

        @Override
        public BaashaaEntity[] newArray(int size) {
            return new BaashaaEntity[size];
        }
    };
}