package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 6/15/2015.
 */
public class Skill implements Parcelable {

    private String name;
    private int mpCost;
    private String description;
    private Boolean isStrain;

    public Skill (String skillName, int cost, String desc, Boolean isStrainSkill){
        this.name = skillName;
        this.mpCost = cost;
        this.description = desc;
        this.isStrain = isStrainSkill;
    }

    public Skill (Parcel source){
        name = source.readString();
        mpCost = source.readInt();
        description = source.readString();
        isStrain = source.readByte() !=0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(mpCost);
        dest.writeString(description);
        dest.writeByte((byte) (isStrain ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<Skill> CREATOR = new Creator<Skill>() {
        @Override
        public Skill createFromParcel(Parcel source) {
            return new Skill(source);
        }

        @Override
        public Skill[] newArray(int size) {
            return new Skill[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsStrain() {
        return isStrain;
    }

    public void setIsStrain(Boolean isStrain) {
        this.isStrain = isStrain;
    }
}
