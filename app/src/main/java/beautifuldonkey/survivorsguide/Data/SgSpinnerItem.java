package beautifuldonkey.survivorsguide.Data;

/**
 * Generic application list item
 * Created by jaw_m on 8/5/2017.
 */

public class SgSpinnerItem {

  public String itemText;

  public SgSpinnerItem(){}

  public SgSpinnerItem(String text){
    this.itemText = text;
  }

  public String getItemText() {
    return itemText;
  }

  public void setItemText(String itemText) {
    this.itemText = itemText;
  }
}
