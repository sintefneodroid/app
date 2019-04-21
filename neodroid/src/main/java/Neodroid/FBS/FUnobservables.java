// automatically generated by the FlatBuffers compiler, do not modify

package Neodroid.FBS;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FUnobservables extends Table {
  public static FUnobservables getRootAsFUnobservables(ByteBuffer _bb) {
    return getRootAsFUnobservables(_bb, new FUnobservables());
  }

  public static FUnobservables getRootAsFUnobservables(ByteBuffer _bb, FUnobservables obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public FUnobservables __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public void __init(int _i, ByteBuffer _bb) {
    bb_pos = _i;
    bb = _bb;
  }

  public static int createFUnobservables(FlatBufferBuilder builder, int posesOffset, int bodiesOffset) {
    builder.startObject(2);
    FUnobservables.addBodies(builder, bodiesOffset);
    FUnobservables.addPoses(builder, posesOffset);
    return FUnobservables.endFUnobservables(builder);
  }

  public static void addPoses(FlatBufferBuilder builder, int posesOffset) {
    builder.addOffset(0, posesOffset, 0);
  }

  public static void addBodies(FlatBufferBuilder builder, int bodiesOffset) {
    builder.addOffset(1, bodiesOffset, 0);
  }

  public static int endFUnobservables(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }

  public static void startFUnobservables(FlatBufferBuilder builder) {
    builder.startObject(2);
  }

  public static void startPosesVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(56, numElems, 8);
  }

  public static void startBodiesVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(48, numElems, 8);
  }

  public FQuaternionTransform poses(int j) {
    return poses(new FQuaternionTransform(), j);
  }

  public FQuaternionTransform poses(FQuaternionTransform obj, int j) {
    int o = __offset(4);
    return o != 0 ? obj.__assign(__vector(o) + j * 56, bb) : null;
  }

  public int posesLength() {
    int o = __offset(4);
    return o != 0 ? __vector_len(o) : 0;
  }

  public FBody bodies(int j) {
    return bodies(new FBody(), j);
  }

  public FBody bodies(FBody obj, int j) {
    int o = __offset(6);
    return o != 0 ? obj.__assign(__vector(o) + j * 48, bb) : null;
  }

  public int bodiesLength() {
    int o = __offset(6);
    return o != 0 ? __vector_len(o) : 0;
  }
}
