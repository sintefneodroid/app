// automatically generated by the FlatBuffers compiler, do not modify

package Neodroid.FBS.Reaction;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FReactions extends Table {
  public static FReactions getRootAsFReactions(ByteBuffer _bb) {
    return getRootAsFReactions(_bb, new FReactions());
  }

  public static FReactions getRootAsFReactions(ByteBuffer _bb, FReactions obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public FReactions __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public void __init(int _i, ByteBuffer _bb) {
    bb_pos = _i;
    bb = _bb;
  }

  public static boolean FReactionsBufferHasIdentifier(ByteBuffer _bb) {
    return __has_identifier(_bb, "XREA");
  }

  public static void startFReactions(FlatBufferBuilder builder) {
    builder.startObject(4);
  }

  public static void addReactions(FlatBufferBuilder builder, int reactionsOffset) {
    builder.addOffset(0, reactionsOffset, 0);
  }

  public static int createReactionsVector(FlatBufferBuilder builder, int[] data) {
    builder.startVector(4, data.length, 4);
    for (int i = data.length - 1; i >= 0; i--)
      builder.addOffset(data[i]);
    return builder.endVector();
  }

  public static void startReactionsVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(4, numElems, 4);
  }

  public static void addApiVersion(FlatBufferBuilder builder, int apiVersionOffset) {
    builder.addOffset(1, apiVersionOffset, 0);
  }

  public static void addSimulatorConfiguration(FlatBufferBuilder builder, int simulatorConfigurationOffset) {
    builder.addStruct(2, simulatorConfigurationOffset, 0);
  }

  public static void addClose(FlatBufferBuilder builder, boolean close) {
    builder.addBoolean(3, close, false);
  }

  public static int endFReactions(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }

  public static void finishFReactionsBuffer(FlatBufferBuilder builder, int offset) {
    builder.finish(offset, "XREA");
  }

  public FReaction reactions(int j) {
    return reactions(new FReaction(), j);
  }

  public FReaction reactions(FReaction obj, int j) {
    int o = __offset(4);
    return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
  }

  public int reactionsLength() {
    int o = __offset(4);
    return o != 0 ? __vector_len(o) : 0;
  }

  public FReaction reactionsByKey(String key) {
    int o = __offset(4);
    return o != 0 ? FReaction.__lookup_by_key(__vector(o), key, bb) : null;
  }

  public String apiVersion() {
    int o = __offset(6);
    return o != 0 ? __string(o + bb_pos) : null;
  }

  public ByteBuffer apiVersionAsByteBuffer() {
    return __vector_as_bytebuffer(6, 1);
  }

  public Neodroid.FBS.FSimulatorConfiguration simulatorConfiguration() {
    return simulatorConfiguration(new Neodroid.FBS.FSimulatorConfiguration());
  }

  public Neodroid.FBS.FSimulatorConfiguration simulatorConfiguration(Neodroid.FBS.FSimulatorConfiguration obj) {
    int o = __offset(8);
    return o != 0 ? obj.__assign(o + bb_pos, bb) : null;
  }

  public boolean close() {
    int o = __offset(10);
    return o != 0 ? 0 != bb.get(o + bb_pos) : false;
  }
}
