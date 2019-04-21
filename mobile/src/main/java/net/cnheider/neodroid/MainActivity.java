package net.cnheider.neodroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  private final static String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.editText_address)
  EditText address_editText;

  @BindView(R.id.editText_port)
  EditText port_editText;

  @BindView(R.id.button_connect)
  Button connect_button;

  @BindView(R.id.button_test)
  Button test_button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    Intent intent = new Intent(this, GyroActivity.class);
    intent.putExtra("address", address_editText.getText().toString() );
    intent.putExtra("port", port_editText.getText().toString());


    connect_button.setOnClickListener(view -> startActivity(intent));

    Intent intent2 = new Intent(this, GyroTestActivity.class);

    test_button.setOnClickListener(view -> startActivity(intent2));
  }
}
