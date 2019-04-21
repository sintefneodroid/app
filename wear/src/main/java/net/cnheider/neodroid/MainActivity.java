package net.cnheider.neodroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends WearableActivity {
  @BindView(R.id.editText_address)
  EditText address_editText;

  @BindView(R.id.editText_port)
  EditText port_editText;

  @BindView(R.id.button_connect)
  Button connect_button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    // Enables Always-on
    setAmbientEnabled();

    Intent intent = new Intent(this, GyroActivity.class);
    intent.putExtra("address", address_editText.getText().toString() );
    intent.putExtra("port", port_editText.getText().toString());


    connect_button.setOnClickListener(view -> startActivity(intent));
  }
}
