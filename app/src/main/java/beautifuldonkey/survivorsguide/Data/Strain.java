package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * defines Strain class
 * Created by user on 6/15/2015.
 */
public class Strain implements Parcelable {

  private String name;
  private int body;
  private int mind;
  private int infection;
  private String skills;
  private String description;

  public Strain(String strainName, int strainBody, int strainMind, int strainInfection, String strainSkills, String strainDesc) {
    name = strainName;
    body = strainBody;
    mind = strainMind;
    infection = strainInfection;
    skills = strainSkills;
    description = strainDesc;
  }

  public Strain(Parcel source) {
    name = source.readString();
    body = source.readInt();
    mind = source.readInt();
    infection = source.readInt();
    skills = source.readString();
    description = source.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeInt(body);
    dest.writeInt(mind);
    dest.writeInt(infection);
    dest.writeString(skills);
    dest.writeString(description);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Strain> CREATOR = new Creator<Strain>() {
    @Override
    public Strain createFromParcel(Parcel source) {
      return new Strain(source);
    }

    @Override
    public Strain[] newArray(int size) {
      return new Strain[size];
    }
  };

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
