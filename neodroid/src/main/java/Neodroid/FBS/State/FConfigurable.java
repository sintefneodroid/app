// automatically generated by the FlatBuffers compiler, do not modify

package Neodroid.FBS.State;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FConfigurable extends Table {
  public static FConfigurable getRootAsFConfigurable(ByteBuffer _bb) {
    return getRootAsFConfigurable(_bb, new FConfigurable());
  }

  public static FConfigurable getRootAsFConfigurable(ByteBuffer _bb, FConfigurable obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public FConfigurable __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public void __init(int _i, ByteBuffer _bb) {
    bb_pos = _i;
    bb = _bb;
  }

  public static int createFConfigurable(FlatBufferBuilder builder, int configurable_nameOffset, byte observation_type, int observationOffset) {
    builder.startObject(3);
    FConfigurable.addObservation(builder, observationOffset);
    FConfigurable.addConfigurableName(builder, configurable_nameOffset);
    FConfigurable.addObservationType(builder, observation_type);
    return FConfigurable.endFConfigurable(builder);
  }

  public static void addConfigurableName(FlatBufferBuilder builder, int configurableNameOffset) {
    builder.addOffset(0, configurableNameOffset, 0);
  }

  public static void addObservationType(FlatBufferBuilder builder, byte observationType) {
    builder.addByte(1, observationType, 0);
  }

  public static void addObservation(FlatBufferBuilder builder, int observationOffset) {
    builder.addOffset(2, observationOffset, 0);
  }

  public static int endFConfigurable(FlatBufferBuilder builder) {
    int o = builder.endObject();
    builder.required(o, 4);  // configurable_name
    return o;
  }

  public static void startFConfigurable(FlatBufferBuilder builder) {
    builder.startObject(3);
  }

  public static FConfigurable __lookup_by_key(int vectorLocation, String key, ByteBuffer bb) {
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
        return new FConfigurable().__assign(tableOffset, bb);
      }
    }
    return null;
  }

  public String configurableName() {
    int o = __offset(4);
    return o != 0 ? __string(o + bb_pos) : null;
  }

  public ByteBuffer configurableNameAsByteBuffer() {
    return __vector_as_bytebuffer(4, 1);
  }

  public byte observationType() {
    int o = __offset(6);
    return o != 0 ? bb.get(o + bb_pos) : 0;
  }

  public Table observation(Table obj) {
    int o = __offset(8);
    return o != 0 ? __union(obj, o) : null;
  }

  @Override
  protected int keysCompare(Integer o1, Integer o2, ByteBuffer _bb) {
    return compareStrings(__offset(4, o1, _bb), __offset(4, o2, _bb), _bb);
  }
}

