package beautifuldonkey.survivorsguide.Manager;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Provides character attribute buttons
 */

public class ButtonManager {

  private TextView charBuild;
  private TextView charBody;
  private TextView charMind;
  private int minBody;
  private int minMind;

  /**
   * Sets up button that will add body to a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param body TextView for character body
   * @param activity Activity setting up the button
   */
  public void characterAddBody(int id, TextView build, TextView body, Activity activity){
    charBuild = build;
    charBody = body;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charBody.getText().toString());
        if (currentBuild > 0) {
          currentStatValue += 1;
          currentBuild -= 1;
          charBody.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will add mind to a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param mind TextView for character mind
   * @param activity Activity setting up the button
   */
  public void characterAddMind(int id, TextView build, TextView mind, Activity activity){
    charBuild = build;
    charMind = mind;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charMind.getText().toString());
        if (currentBuild > 0) {
          currentStatValue += 1;
          currentBuild -= 1;
          charMind.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will remove body from a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param body TextView for character body
   * @param activity Activity setting up the button
   * @param minVal Minimum value based on character strain
   */
  public void characterSubtractBody(int id, TextView build, TextView body, Activity activity, int minVal){
    charBuild = build;
    charBody = body;
    minBody = minVal;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charBody.getText().toString());
        if (currentStatValue > minBody) {
          currentStatValue -= 1;
          currentBuild += 1;
          charBody.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

  /**
   * Sets up button that will remove mind from a character
   * @param id id of the button element
   * @param build TextView for character build
   * @param mind TextView for character mind
   * @param activity Activity setting up the button
   * @param minVal Minimum value based on character strain
   */
  public void characterSubtractMind(int id, TextView build, TextView mind, Activity activity, int minVal){
    charBuild = build;
    charMind = mind;
    minMind = minVal;

    Button button = (Button) activity.findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Integer currentBuild = Integer.parseInt(charBuild.getText().toString());
        Integer currentStatValue = Integer.parseInt(charMind.getText().toString());
        if (currentStatValue > minMind) {
          currentStatValue -= 1;
          currentBuild += 1;
          charMind.setText(String.valueOf(currentStatValue));
          charBuild.setText(String.valueOf(currentBuild));
        }
      }
    });
  }

}
