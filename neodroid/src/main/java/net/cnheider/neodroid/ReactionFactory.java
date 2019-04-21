package net.cnheider.neodroid;

import Neodroid.FBS.Reaction.FReactions;
import com.google.flatbuffers.FlatBufferBuilder;

public class ReactionFactory {
  private final static String TAG = ReactionFactory.class.getSimpleName();
  ReactionFactory() {

  }

  byte[] demo_function(String a) {
    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1);

    int api_offset = flatBufferBuilder.createString("0.1.0");

    FReactions.startFReactions(flatBufferBuilder);
    FReactions.addClose(flatBufferBuilder,false);
    FReactions.addApiVersion(flatBufferBuilder,api_offset);
    int offset = FReactions.endFReactions(flatBufferBuilder);
    flatBufferBuilder.finish(offset);

    return flatBufferBuilder.sizedByteArray();
  }

}
