package net.cnheider.neodroid;

import android.os.AsyncTask;
import android.os.Handler;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class SendReactionTask extends AsyncTask<byte[], Void, String> {
  private final static String TAG = SendReactionTask.class.getSimpleName();

  private final Handler uiThreadHandler;
  private String address;
  private String port;


  SendReactionTask(Handler uiThreadHandler, String address, String port) {
    this.uiThreadHandler = uiThreadHandler;
    this.address = address;
    this.port = port;
  }

  @Override
  protected String doInBackground(byte[]... bytes) {
    String result="Nothing";
    try (ZContext context = new ZContext()) {
      ZMQ.Socket socket = context.createSocket(SocketType.REQ);
      socket.setReceiveTimeOut(1000);
      String target = "tcp://" + address + ":" + port;
      boolean res = socket.connect(target);
      //socket.disconnect(target);

      if(res) {
        socket.send(bytes[0], 0);

        byte[] re= socket.recv(0);
        if(re != null && re.length>0) {
          result = new String(re);
        }
      }
    }

    return result;
  }

  @Override
  protected void onPostExecute(String result) {
    uiThreadHandler.sendMessage(MessageUtilities.bundledMessage(uiThreadHandler, result));
  }
}