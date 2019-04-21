package net.cnheider.neodroid;


import android.os.Handler;
import android.os.Message;

public class UnpackingStateMessageHandler extends Handler {
  private final IStateListener messageListener;
  private final String payloadKey;

  public UnpackingStateMessageHandler(IStateListener messageListener, String payloadKey) {
    this.messageListener = messageListener;
    this.payloadKey = payloadKey;
  }

  @Override
  public void handleMessage(Message msg) {
    messageListener.messageReceived(msg.getData().getString(payloadKey));
  }
}