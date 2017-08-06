package beautifuldonkey.survivorsguide.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines Character JSON structure saved to internal storage
 * Created by user on 6/15/2015.
 */
public class PlayerCharacter implements Parcelable {

  private String name;
  private String health;
  private String mind;
  private String strain;
  private String infection;
  private List<Profession> professions;
  private List<Skill> selectedSkills;
  private String availBuild;
  private String requiredBuild;

  public PlayerCharacter(){}

  public PlayerCharacter(String charName, String charHealth, String charMind, String charStrain
      , String charInfection, List<Profession> charProfs, List<Skill> selectedSkills, String availBuild
      , String requiredBuild) {
    this.name = charName;
    this.health = charHealth;
    this.mind = charMind;
    this.strain = charStrain;
    this.infection = charInfection;
    this.professions = charProfs;
    this.selectedSkills = selectedSkills;
    this.availBuild = availBuild;
    this.requiredBuild = requiredBuild;
  }

  public PlayerCharacter(Parcel source) {
    name = source.readString();
    health = source.readString();
    mind = source.readString();
    strain = source.readString();
    infection = source.readString();
    professions = new ArrayList<>();
    selectedSkills = new ArrayList<>();
    source.readTypedList(professions,Profession.CREATOR);
    source.readTypedList(selectedSkills,Skill.CREATOR);
    availBuild = source.readString();
    requiredBuild = source.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(health);
    dest.writeString(mind);
    dest.writeString(strain);
    dest.writeString(infection);
//    professions = new ArrayList<>();
//    selectedSkills = new ArrayList<>();
    dest.writeTypedList(professions);
    dest.writeTypedList(selectedSkills);
    dest.writeString(availBuild);
    dest.writeString(requiredBuild);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static Creator<PlayerCharacter> CREATOR = new Creator<PlayerCharacter>() {
    @Override
    public PlayerCharacter createFromParcel(Parcel source) {
      return new PlayerCharacter(source);
    }

    @Override
    public PlayerCharacter[] newArray(int size) {
      return new PlayerCharacter[size];
    }
  };

  public String getAvailBuild() {
    return availBuild;
  }

  public void setAvailBuild(String availBuild) {
    this.availBuild = availBuild;
  }

  public String getInfection() {
    return infection;
  }

  public void setInfection(String infection) {
    this.infection = infection;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHealth() {
    return health;
  }

  public void setHealth(String health) {
    this.health = health;
  }

  public String getMind() {
    return mind;
  }

  public void setMind(String mind) {
    this.mind = mind;
  }

  public String getStrain() {
    return strain;
  }

  public void setStrain(String strain) {
    this.strain = strain;
  }

  public List<Profession> getProfessions() {
    return professions;
  }

  public void setProfessions(List<Profession> professions) {
    this.professions = professions;
  }

  public List<Skill> getSelectedSkills() {
    return selectedSkills;
  }

  public void setSelectedSkills(List<Skill> selectedSkills) {
    this.selectedSkills = selectedSkills;
  }

  public String getRequiredBuild() {
    return requiredBuild;
  }

  public void setRequiredBuild(String requiredBuild) {
    this.requiredBuild = requiredBuild;
  }
}
