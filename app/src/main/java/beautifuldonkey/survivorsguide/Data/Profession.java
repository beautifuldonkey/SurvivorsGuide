package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 6/15/2015.
 */
public class Profession implements Parcelable {

    private String name;
    private String description;
    private String skills;
    private String strainReqs;

    public Profession (String profName, String profDesc, String profSkills, String profStrainReqs){
        this.name = profName;
        this.description = profDesc;
        this.skills = profSkills;
        this.strainReqs = profStrainReqs;
    }

    public Profession(Parcel source){
        name = source.readString();
        description = source.readString();
        skills = source.readString();
        strainReqs = source.readString();
    }

    public static Creator<Profession> CREATOR = new Creator<Profession>() {
        @Override
        public Profession createFromParcel(Parcel source) {
            return new Profession(source);
        }

        @Override
        public Profession[] newArray(int size) {
            return new Profession[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(skills);
        dest.writeString(strainReqs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getStrainReqs() {
        return strainReqs;
    }

    public void setStrainReqs(String strainReqs) {
        this.strainReqs = strainReqs;
    }
}
