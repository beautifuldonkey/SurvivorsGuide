package beautifuldonkey.survivorsguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class CharacterActivity extends AppCompatActivity {

  public static int NEW_CHARACTER_ACTIVITY = 20;
  public static int EXISTING_CHARACTER_ACTIVITY = 21;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_character);

    Button btnNewChar = (Button) findViewById(R.id.btnNewCharacter);
    btnNewChar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, CharacterNewActivity.class);
        startActivityForResult(intent, NEW_CHARACTER_ACTIVITY);
      }
    });

    Button btnExistingChar = (Button) findViewById(R.id.btnExistingCharacter);
    btnExistingChar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, CharacterExistingActivity.class);
        startActivityForResult(intent, EXISTING_CHARACTER_ACTIVITY);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_character, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
