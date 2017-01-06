package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Defines Skill class
 * Created by user on 6/15/2015.
 */
public class Skill implements Parcelable {

  private String name;
  private int mpCost;
  private String description;
  private Boolean isStrain;
  private int buildCost;
  private int currRank;
  private int availRank;

  public Skill (){}

  public Skill(String skillName, int cost, String desc, Boolean isStrainSkill, int build, int currentRank, int availableRank) {
    this.name = skillName;
    this.mpCost = cost;
    this.description = desc;
    this.isStrain = isStrainSkill;
    this.buildCost = build;
    this.currRank = currentRank;
    this.availRank = availableRank;
  }

  public Skill(Parcel source) {
    name = source.readString();
    mpCost = source.readInt();
    description = source.readString();
    isStrain = source.readByte() != 0;
    buildCost = source.readInt();
    currRank = source.readInt();
    availRank = source.readInt();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeInt(mpCost);
    dest.writeString(description);
    dest.writeByte((byte) (isStrain ? 1 : 0));
    dest.writeInt(buildCost);
    dest.writeInt(currRank);
    dest.writeInt(availRank);
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

  public int getCurrRank() {
    return currRank;
  }

  public void setCurrRank(int currRank) {
    this.currRank = currRank;
  }

  public int getAvailRank() {
    return availRank;
  }

  public void setAvailRank(int availRank) {
    this.availRank = availRank;
  }

  public int getBuildCost() {
    return buildCost;
  }

  public void setBuildCost(int buildCost) {
    this.buildCost = buildCost;
  }

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
