// automatically generated by the FlatBuffers compiler, do not modify

package Neodroid.FBS.State;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class FEnvironmentDescription extends Table {
  public static FEnvironmentDescription getRootAsFEnvironmentDescription(ByteBuffer _bb) {
    return getRootAsFEnvironmentDescription(_bb, new FEnvironmentDescription());
  }

  public static FEnvironmentDescription getRootAsFEnvironmentDescription(ByteBuffer _bb, FEnvironmentDescription obj) {
    _bb.order(ByteOrder.LITTLE_ENDIAN);
    return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
  }

  public FEnvironmentDescription __assign(int _i, ByteBuffer _bb) {
    __init(_i, _bb);
    return this;
  }

  public void __init(int _i, ByteBuffer _bb) {
    bb_pos = _i;
    bb = _bb;
  }

  public static int createFEnvironmentDescription(FlatBufferBuilder builder, int objectiveOffset, int available_objectivesOffset, int actorsOffset, int configurablesOffset) {
    builder.startObject(4);
    FEnvironmentDescription.addConfigurables(builder, configurablesOffset);
    FEnvironmentDescription.addActors(builder, actorsOffset);
    FEnvironmentDescription.addAvailableObjectives(builder, available_objectivesOffset);
    FEnvironmentDescription.addObjective(builder, objectiveOffset);
    return FEnvironmentDescription.endFEnvironmentDescription(builder);
  }

  public static void addObjective(FlatBufferBuilder builder, int objectiveOffset) {
    builder.addOffset(0, objectiveOffset, 0);
  }

  public static void addAvailableObjectives(FlatBufferBuilder builder, int availableObjectivesOffset) {
    builder.addOffset(1, availableObjectivesOffset, 0);
  }

  public static void addActors(FlatBufferBuilder builder, int actorsOffset) {
    builder.addOffset(2, actorsOffset, 0);
  }

  public static void addConfigurables(FlatBufferBuilder builder, int configurablesOffset) {
    builder.addOffset(3, configurablesOffset, 0);
  }

  public static int endFEnvironmentDescription(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }

  public static void startFEnvironmentDescription(FlatBufferBuilder builder) {
    builder.startObject(4);
  }

  public static int createAvailableObjectivesVector(FlatBufferBuilder builder, int[] data) {
    builder.startVector(4, data.length, 4);
    for (int i = data.length - 1; i >= 0; i--)
      builder.addOffset(data[i]);
    return builder.endVector();
  }

  public static void startAvailableObjectivesVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(4, numElems, 4);
  }

  public static int createActorsVector(FlatBufferBuilder builder, int[] data) {
    builder.startVector(4, data.length, 4);
    for (int i = data.length - 1; i >= 0; i--)
      builder.addOffset(data[i]);
    return builder.endVector();
  }

  public static void startActorsVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(4, numElems, 4);
  }

  public static int createConfigurablesVector(FlatBufferBuilder builder, int[] data) {
    builder.startVector(4, data.length, 4);
    for (int i = data.length - 1; i >= 0; i--)
      builder.addOffset(data[i]);
    return builder.endVector();
  }

  public static void startConfigurablesVector(FlatBufferBuilder builder, int numElems) {
    builder.startVector(4, numElems, 4);
  }

  public FObjective objective() {
    return objective(new FObjective());
  }

  public FObjective objective(FObjective obj) {
    int o = __offset(4);
    return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null;
  }

  public FObjective availableObjectives(int j) {
    return availableObjectives(new FObjective(), j);
  }

  public FObjective availableObjectives(FObjective obj, int j) {
    int o = __offset(6);
    return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
  }

  public int availableObjectivesLength() {
    int o = __offset(6);
    return o != 0 ? __vector_len(o) : 0;
  }

  public FActor actors(int j) {
    return actors(new FActor(), j);
  }

  public FActor actors(FActor obj, int j) {
    int o = __offset(8);
    return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
  }

  public int actorsLength() {
    int o = __offset(8);
    return o != 0 ? __vector_len(o) : 0;
  }

  public FActor actorsByKey(String key) {
    int o = __offset(8);
    return o != 0 ? FActor.__lookup_by_key(__vector(o), key, bb) : null;
  }

  public FConfigurable configurables(int j) {
    return configurables(new FConfigurable(), j);
  }

  public FConfigurable configurables(FConfigurable obj, int j) {
    int o = __offset(10);
    return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
  }

  public int configurablesLength() {
    int o = __offset(10);
    return o != 0 ? __vector_len(o) : 0;
  }

  public FConfigurable configurablesByKey(String key) {
    int o = __offset(10);
    return o != 0 ? FConfigurable.__lookup_by_key(__vector(o), key, bb) : null;
  }
}

