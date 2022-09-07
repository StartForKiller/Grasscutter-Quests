// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BalloonSettleInfo.proto

package emu.grasscutter.net.proto;

public final class BalloonSettleInfoOuterClass {
  private BalloonSettleInfoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface BalloonSettleInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:BalloonSettleInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 uid = 3;</code>
     * @return The uid.
     */
    int getUid();

    /**
     * <code>uint32 shoot_count = 12;</code>
     * @return The shootCount.
     */
    int getShootCount();

    /**
     * <code>uint32 max_combo = 9;</code>
     * @return The maxCombo.
     */
    int getMaxCombo();

    /**
     * <code>uint32 final_score = 7;</code>
     * @return The finalScore.
     */
    int getFinalScore();

    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     * @return Whether the playerInfo field is set.
     */
    boolean hasPlayerInfo();
    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     * @return The playerInfo.
     */
    emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo();
    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     */
    emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder();
  }
  /**
   * Protobuf type {@code BalloonSettleInfo}
   */
  public static final class BalloonSettleInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:BalloonSettleInfo)
      BalloonSettleInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use BalloonSettleInfo.newBuilder() to construct.
    private BalloonSettleInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private BalloonSettleInfo() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new BalloonSettleInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private BalloonSettleInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 18: {
              emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder subBuilder = null;
              if (playerInfo_ != null) {
                subBuilder = playerInfo_.toBuilder();
              }
              playerInfo_ = input.readMessage(emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(playerInfo_);
                playerInfo_ = subBuilder.buildPartial();
              }

              break;
            }
            case 24: {

              uid_ = input.readUInt32();
              break;
            }
            case 56: {

              finalScore_ = input.readUInt32();
              break;
            }
            case 72: {

              maxCombo_ = input.readUInt32();
              break;
            }
            case 96: {

              shootCount_ = input.readUInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.internal_static_BalloonSettleInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.internal_static_BalloonSettleInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.class, emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.Builder.class);
    }

    public static final int UID_FIELD_NUMBER = 3;
    private int uid_;
    /**
     * <code>uint32 uid = 3;</code>
     * @return The uid.
     */
    @java.lang.Override
    public int getUid() {
      return uid_;
    }

    public static final int SHOOT_COUNT_FIELD_NUMBER = 12;
    private int shootCount_;
    /**
     * <code>uint32 shoot_count = 12;</code>
     * @return The shootCount.
     */
    @java.lang.Override
    public int getShootCount() {
      return shootCount_;
    }

    public static final int MAX_COMBO_FIELD_NUMBER = 9;
    private int maxCombo_;
    /**
     * <code>uint32 max_combo = 9;</code>
     * @return The maxCombo.
     */
    @java.lang.Override
    public int getMaxCombo() {
      return maxCombo_;
    }

    public static final int FINAL_SCORE_FIELD_NUMBER = 7;
    private int finalScore_;
    /**
     * <code>uint32 final_score = 7;</code>
     * @return The finalScore.
     */
    @java.lang.Override
    public int getFinalScore() {
      return finalScore_;
    }

    public static final int PLAYER_INFO_FIELD_NUMBER = 2;
    private emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo playerInfo_;
    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     * @return Whether the playerInfo field is set.
     */
    @java.lang.Override
    public boolean hasPlayerInfo() {
      return playerInfo_ != null;
    }
    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     * @return The playerInfo.
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo() {
      return playerInfo_ == null ? emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : playerInfo_;
    }
    /**
     * <code>.OnlinePlayerInfo player_info = 2;</code>
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder() {
      return getPlayerInfo();
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (playerInfo_ != null) {
        output.writeMessage(2, getPlayerInfo());
      }
      if (uid_ != 0) {
        output.writeUInt32(3, uid_);
      }
      if (finalScore_ != 0) {
        output.writeUInt32(7, finalScore_);
      }
      if (maxCombo_ != 0) {
        output.writeUInt32(9, maxCombo_);
      }
      if (shootCount_ != 0) {
        output.writeUInt32(12, shootCount_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (playerInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getPlayerInfo());
      }
      if (uid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, uid_);
      }
      if (finalScore_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(7, finalScore_);
      }
      if (maxCombo_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(9, maxCombo_);
      }
      if (shootCount_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(12, shootCount_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo other = (emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo) obj;

      if (getUid()
          != other.getUid()) return false;
      if (getShootCount()
          != other.getShootCount()) return false;
      if (getMaxCombo()
          != other.getMaxCombo()) return false;
      if (getFinalScore()
          != other.getFinalScore()) return false;
      if (hasPlayerInfo() != other.hasPlayerInfo()) return false;
      if (hasPlayerInfo()) {
        if (!getPlayerInfo()
            .equals(other.getPlayerInfo())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + UID_FIELD_NUMBER;
      hash = (53 * hash) + getUid();
      hash = (37 * hash) + SHOOT_COUNT_FIELD_NUMBER;
      hash = (53 * hash) + getShootCount();
      hash = (37 * hash) + MAX_COMBO_FIELD_NUMBER;
      hash = (53 * hash) + getMaxCombo();
      hash = (37 * hash) + FINAL_SCORE_FIELD_NUMBER;
      hash = (53 * hash) + getFinalScore();
      if (hasPlayerInfo()) {
        hash = (37 * hash) + PLAYER_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getPlayerInfo().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code BalloonSettleInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:BalloonSettleInfo)
        emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.internal_static_BalloonSettleInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.internal_static_BalloonSettleInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.class, emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        uid_ = 0;

        shootCount_ = 0;

        maxCombo_ = 0;

        finalScore_ = 0;

        if (playerInfoBuilder_ == null) {
          playerInfo_ = null;
        } else {
          playerInfo_ = null;
          playerInfoBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.internal_static_BalloonSettleInfo_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo build() {
        emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo buildPartial() {
        emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo result = new emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo(this);
        result.uid_ = uid_;
        result.shootCount_ = shootCount_;
        result.maxCombo_ = maxCombo_;
        result.finalScore_ = finalScore_;
        if (playerInfoBuilder_ == null) {
          result.playerInfo_ = playerInfo_;
        } else {
          result.playerInfo_ = playerInfoBuilder_.build();
        }
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo) {
          return mergeFrom((emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo other) {
        if (other == emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo.getDefaultInstance()) return this;
        if (other.getUid() != 0) {
          setUid(other.getUid());
        }
        if (other.getShootCount() != 0) {
          setShootCount(other.getShootCount());
        }
        if (other.getMaxCombo() != 0) {
          setMaxCombo(other.getMaxCombo());
        }
        if (other.getFinalScore() != 0) {
          setFinalScore(other.getFinalScore());
        }
        if (other.hasPlayerInfo()) {
          mergePlayerInfo(other.getPlayerInfo());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int uid_ ;
      /**
       * <code>uint32 uid = 3;</code>
       * @return The uid.
       */
      @java.lang.Override
      public int getUid() {
        return uid_;
      }
      /**
       * <code>uint32 uid = 3;</code>
       * @param value The uid to set.
       * @return This builder for chaining.
       */
      public Builder setUid(int value) {
        
        uid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 uid = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearUid() {
        
        uid_ = 0;
        onChanged();
        return this;
      }

      private int shootCount_ ;
      /**
       * <code>uint32 shoot_count = 12;</code>
       * @return The shootCount.
       */
      @java.lang.Override
      public int getShootCount() {
        return shootCount_;
      }
      /**
       * <code>uint32 shoot_count = 12;</code>
       * @param value The shootCount to set.
       * @return This builder for chaining.
       */
      public Builder setShootCount(int value) {
        
        shootCount_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 shoot_count = 12;</code>
       * @return This builder for chaining.
       */
      public Builder clearShootCount() {
        
        shootCount_ = 0;
        onChanged();
        return this;
      }

      private int maxCombo_ ;
      /**
       * <code>uint32 max_combo = 9;</code>
       * @return The maxCombo.
       */
      @java.lang.Override
      public int getMaxCombo() {
        return maxCombo_;
      }
      /**
       * <code>uint32 max_combo = 9;</code>
       * @param value The maxCombo to set.
       * @return This builder for chaining.
       */
      public Builder setMaxCombo(int value) {
        
        maxCombo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 max_combo = 9;</code>
       * @return This builder for chaining.
       */
      public Builder clearMaxCombo() {
        
        maxCombo_ = 0;
        onChanged();
        return this;
      }

      private int finalScore_ ;
      /**
       * <code>uint32 final_score = 7;</code>
       * @return The finalScore.
       */
      @java.lang.Override
      public int getFinalScore() {
        return finalScore_;
      }
      /**
       * <code>uint32 final_score = 7;</code>
       * @param value The finalScore to set.
       * @return This builder for chaining.
       */
      public Builder setFinalScore(int value) {
        
        finalScore_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 final_score = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearFinalScore() {
        
        finalScore_ = 0;
        onChanged();
        return this;
      }

      private emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo playerInfo_;
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> playerInfoBuilder_;
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       * @return Whether the playerInfo field is set.
       */
      public boolean hasPlayerInfo() {
        return playerInfoBuilder_ != null || playerInfo_ != null;
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       * @return The playerInfo.
       */
      public emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo getPlayerInfo() {
        if (playerInfoBuilder_ == null) {
          return playerInfo_ == null ? emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : playerInfo_;
        } else {
          return playerInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public Builder setPlayerInfo(emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
        if (playerInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          playerInfo_ = value;
          onChanged();
        } else {
          playerInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public Builder setPlayerInfo(
          emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder builderForValue) {
        if (playerInfoBuilder_ == null) {
          playerInfo_ = builderForValue.build();
          onChanged();
        } else {
          playerInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public Builder mergePlayerInfo(emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo value) {
        if (playerInfoBuilder_ == null) {
          if (playerInfo_ != null) {
            playerInfo_ =
              emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder(playerInfo_).mergeFrom(value).buildPartial();
          } else {
            playerInfo_ = value;
          }
          onChanged();
        } else {
          playerInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public Builder clearPlayerInfo() {
        if (playerInfoBuilder_ == null) {
          playerInfo_ = null;
          onChanged();
        } else {
          playerInfo_ = null;
          playerInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder getPlayerInfoBuilder() {
        
        onChanged();
        return getPlayerInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      public emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder getPlayerInfoOrBuilder() {
        if (playerInfoBuilder_ != null) {
          return playerInfoBuilder_.getMessageOrBuilder();
        } else {
          return playerInfo_ == null ?
              emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.getDefaultInstance() : playerInfo_;
        }
      }
      /**
       * <code>.OnlinePlayerInfo player_info = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder> 
          getPlayerInfoFieldBuilder() {
        if (playerInfoBuilder_ == null) {
          playerInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder, emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.OnlinePlayerInfoOrBuilder>(
                  getPlayerInfo(),
                  getParentForChildren(),
                  isClean());
          playerInfo_ = null;
        }
        return playerInfoBuilder_;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:BalloonSettleInfo)
    }

    // @@protoc_insertion_point(class_scope:BalloonSettleInfo)
    private static final emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo();
    }

    public static emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BalloonSettleInfo>
        PARSER = new com.google.protobuf.AbstractParser<BalloonSettleInfo>() {
      @java.lang.Override
      public BalloonSettleInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new BalloonSettleInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<BalloonSettleInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BalloonSettleInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.BalloonSettleInfoOuterClass.BalloonSettleInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BalloonSettleInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BalloonSettleInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027BalloonSettleInfo.proto\032\026OnlinePlayerI" +
      "nfo.proto\"\205\001\n\021BalloonSettleInfo\022\013\n\003uid\030\003" +
      " \001(\r\022\023\n\013shoot_count\030\014 \001(\r\022\021\n\tmax_combo\030\t" +
      " \001(\r\022\023\n\013final_score\030\007 \001(\r\022&\n\013player_info" +
      "\030\002 \001(\0132\021.OnlinePlayerInfoB\033\n\031emu.grasscu" +
      "tter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.getDescriptor(),
        });
    internal_static_BalloonSettleInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_BalloonSettleInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BalloonSettleInfo_descriptor,
        new java.lang.String[] { "Uid", "ShootCount", "MaxCombo", "FinalScore", "PlayerInfo", });
    emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
