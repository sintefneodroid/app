// automatically generated by the FlatBuffers compiler, do not modify

package Neodroid.FBS.Reaction;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FMotion extends Table {
  public static FMotion getRootAsFMotion(ByteBuffer _bb) {
    return getRootAsFMotion(_bb, new FMotion());
  }

  public static FMotion getRootAsFMotion(ByteBuffer _bb, FMotion obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public FMotion __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public void __init(int _i, ByteBuffer _bb) {
    bb_pos = _i;
    bb = _bb;
  }

  public static int createFMotion(FlatBufferBuilder builder, int actor_nameOffset, int motor_nameOffset, double strength) {
    builder.startObject(3);
    FMotion.addStrength(builder, strength);
    FMotion.addMotorName(builder, motor_nameOffset);
    FMotion.addActorName(builder, actor_nameOffset);
    return FMotion.endFMotion(builder);
  }

  public static void addActorName(FlatBufferBuilder builder, int actorNameOffset) {
    builder.addOffset(0, actorNameOffset, 0);
  }

  public static void addMotorName(FlatBufferBuilder builder, int motorNameOffset) {
    builder.addOffset(1, motorNameOffset, 0);
  }

  public static void addStrength(FlatBufferBuilder builder, double strength) {
    builder.addDouble(2, strength, 0.0);
  }

  public static int endFMotion(FlatBufferBuilder builder) {
    int o = builder.endObject();
    builder.required(o, 4);  // actor_name
    builder.required(o, 6);  // motor_name
    return o;
  }

  public static void startFMotion(FlatBufferBuilder builder) {
    builder.startObject(3);
  }

  public static FMotion __lookup_by_key(int vectorLocation, String key, ByteBuffer bb) {
    byte[] byteKey = key.getBytes(Table.UTF8_CHARSET.get());
    int span = bb.getInt(vectorLocation - 4);
    int start = 0;
    while (span != 0) {
      int middle = span / 2;
      int tableOffset = __indirect(vectorLocation + 4 * (start + middle), bb);
      int comp = compareStrings(__offset(4, bb.capacity() - tableOffset, bb), byteKey, bb);
      if (comp > 0) {
        span = middle;
      } else if (comp < 0) {
        middle++;
        start += middle;
        span -= middle;
      } else {
        return new FMotion().__assign(tableOffset, bb);
      }
    }
    return null;
  }

  public String actorName() {
    int o = __offset(4);
    return o != 0 ? __string(o + bb_pos) : null;
  }

  public ByteBuffer actorNameAsByteBuffer() {
    return __vector_as_bytebuffer(4, 1);
  }

  public String motorName() {
    int o = __offset(6);
    return o != 0 ? __string(o + bb_pos) : null;
  }

  public ByteBuffer motorNameAsByteBuffer() {
    return __vector_as_bytebuffer(6, 1);
  }

  public double strength() {
    int o = __offset(8);
    return o != 0 ? bb.getDouble(o + bb_pos) : 0.0;
  }

  @Override
  protected int keysCompare(Integer o1, Integer o2, ByteBuffer _bb) {
    return compareStrings(__offset(4, o1, _bb), __offset(4, o2, _bb), _bb);
  }
}

