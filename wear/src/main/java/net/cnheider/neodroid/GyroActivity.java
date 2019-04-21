package net.cnheider.neodroid;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class GyroActivity extends WearableActivity implements SensorEventListener {
  private final static String TAG = GyroActivity.class.getSimpleName();
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.UK);

  private final UnpackingStateMessageHandler ProxyMessageHandler = new UnpackingStateMessageHandler(this::clientMessageReceived, MessageUtilities.MESSAGE_PAYLOAD_KEY);

  @BindView(R.id.text_observation)
  TextView textView;
  @BindView(R.id.text_reaction)
  TextView editText;
  @BindView(R.id.imageView_gyro)
  View imageView_gyro;
  private SensorManager sensor_manager;
  private Sensor sensor;
  private final float[] _rotation_matrix = new float[16];

  private final float[] mQuat = new float[4];
  ReactionFactory reactionFactory;
  byte[] bytes;
  private final int samplingPeriodUs = SensorManager.SENSOR_DELAY_FASTEST;//SensorManager
  // .SENSOR_DELAY_NORMAL; // 100 ms

  ConnectivityManager.NetworkCallback networkCallback;
  ConnectivityManager connectivityManager;

  String address;
  String port;
  private boolean ready =false;


  private void clientMessageReceived(String messageBody) {
    textView.append(TAG + getTimeString() + " - client received: " + messageBody + "\n");

    textView.setText(messageBody);
ready =true;
  }

  private static String getTimeString() {
    return DATE_FORMAT.format(new Date());
  }

  @Override
  public void onSensorChanged(SensorEvent sensorEvent) {

    if(!ready)
      return;
    ready =false;

    // we received a sensor event. it is a good practice to check
    // that we received the proper event
    if (sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
      // convert the rotation-vector to a 4x4 matrix. the matrix
      // is interpreted by Open GL as the inverse of the
      // rotation-vector, which is what we want.
      //SensorManager.getRotationMatrixFromVector(_rotation_matrix, sensorEvent.values);

      SensorManager.getQuaternionFromVector(mQuat, sensorEvent.values);

      imageView_gyro.setPadding((int)(mQuat[0]*10),(int)(mQuat[1]*10),(int)(mQuat[2]*10),(int)(mQuat[3]*10));

      String str_rep = Arrays.toString(mQuat);
      editText.setText(str_rep);
      bytes = reactionFactory.demo_function(str_rep);

      SendReactionTask task = new SendReactionTask(ProxyMessageHandler, address, port);
      task.execute(bytes);
    } else if (sensorEvent.sensor.getType() == Sensor.TYPE_POSE_6DOF) {

      MyPose mLatestPoseData = new MyPose(sensorEvent.values, sensorEvent.timestamp);

      String str_rep = mLatestPoseData.toString();
      editText.setText(str_rep);
      bytes = reactionFactory.demo_function(str_rep);

      SendReactionTask task = new SendReactionTask(ProxyMessageHandler, address, port);
      task.execute(bytes);
    }

  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int i) {

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gyro);
    ButterKnife.bind(this);

    // Enables Always-on
    setAmbientEnabled();

    Bundle extras = getIntent().getExtras();
    address = extras.getString("address");
    port = extras.getString("port");

    Log.d(TAG, "address: " + address);
    Log.d(TAG, "port: " + port);

    networkCallback = new ConnectivityManager.NetworkCallback() {
      @Override
      public void onAvailable(Network network) {
        if (connectivityManager.bindProcessToNetwork(network)) {
          Log.d(TAG,"socket connections will now use requested network");
          ready =true;
        } else {
          ready =false;
          Log.d(TAG,"app doesn't have android.permission.INTERNET permission");
        }
      }

      @Override
      public void onCapabilitiesChanged(Network network,
                                        NetworkCapabilities networkCapabilities) {
        Log.d(TAG, "Network capabilities changed");
      }

      @Override
      public void onLost(Network network) {
        Log.d(TAG, "Network lost");

      }
    };

    NetworkRequest request = new NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .addCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build();

    connectivityManager.requestNetwork(request, networkCallback);

    // initialize the rotation matrix to identity
    _rotation_matrix[0] = 1;
    _rotation_matrix[4] = 1;
    _rotation_matrix[8] = 1;
    _rotation_matrix[12] = 1;

    sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    //sensor = sensor_manager.getDefaultSensor(Sensor.TYPE_POSE_6DOF);

    reactionFactory = new ReactionFactory();

  }

  @Override
  protected void onResume() {
    super.onResume();
    boolean setupSuccessful = sensor_manager.registerListener(this, sensor, samplingPeriodUs);

    if (!setupSuccessful) {
      Log.e(TAG, "Failed to setup sensor");
    }

  }

  @Override
  protected void onPause() {
    super.onPause();
    sensor_manager.unregisterListener(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    connectivityManager.bindProcessToNetwork(null);
    connectivityManager.unregisterNetworkCallback(networkCallback);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    } else if (id == R.id.action_exit) {
      this.finish();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}