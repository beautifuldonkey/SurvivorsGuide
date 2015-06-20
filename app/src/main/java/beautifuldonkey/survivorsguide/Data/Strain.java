package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 6/15/2015.
 */
public class Strain implements Parcelable {

    private String name;
    private int body;
    private int mind;
    private int infection;
    private String skills;

    public Strain (String strainName, int strainBody, int strainMind, int strainInfection, String strainSkills){
        name        = strainName;
        body        = strainBody;
        mind        = strainMind;
        infection   = strainInfection;
        skills      = strainSkills;
    }

    public Strain (Parcel source){
        name        = source.readString();
        body        = source.readInt();
        mind        = source.readInt();
        infection   = source.readInt();
        skills      = source.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(body);
        dest.writeInt(mind);
        dest.writeInt(infection);
        dest.writeString(skills);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int health) {
        this.body = health;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getInfection() {
        return infection;
    }

    public void setInfection(int infection) {
        this.infection = infection;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
