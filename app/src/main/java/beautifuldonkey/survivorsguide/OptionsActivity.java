package beautifuldonkey.survivorsguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OptionsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_options);

    TextView txtTextSize = (TextView) findViewById(R.id.textSize);
    int dp = (int) (getResources().getDimension(R.dimen.charActivityText) / getResources().getDisplayMetrics().density);
    txtTextSize.setText(String.valueOf(dp));
  }
}
