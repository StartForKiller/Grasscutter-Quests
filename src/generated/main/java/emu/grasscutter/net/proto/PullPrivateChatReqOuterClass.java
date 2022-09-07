// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PullPrivateChatReq.proto

package emu.grasscutter.net.proto;

public final class PullPrivateChatReqOuterClass {
  private PullPrivateChatReqOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PullPrivateChatReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PullPrivateChatReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 target_uid = 5;</code>
     * @return The targetUid.
     */
    int getTargetUid();

    /**
     * <code>uint32 pull_num = 7;</code>
     * @return The pullNum.
     */
    int getPullNum();

    /**
     * <code>uint32 from_sequence = 12;</code>
     * @return The fromSequence.
     */
    int getFromSequence();
  }
  /**
   * <pre>
   * CmdId: 4971
   * EnetChannelId: 0
   * EnetIsReliable: true
   * IsAllowClient: true
   * </pre>
   *
   * Protobuf type {@code PullPrivateChatReq}
   */
  public static final class PullPrivateChatReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PullPrivateChatReq)
      PullPrivateChatReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PullPrivateChatReq.newBuilder() to construct.
    private PullPrivateChatReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PullPrivateChatReq() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new PullPrivateChatReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PullPrivateChatReq(
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
            case 40: {

              targetUid_ = input.readUInt32();
              break;
            }
            case 56: {

              pullNum_ = input.readUInt32();
              break;
            }
            case 96: {

              fromSequence_ = input.readUInt32();
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
      return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.class, emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.Builder.class);
    }

    public static final int TARGET_UID_FIELD_NUMBER = 5;
    private int targetUid_;
    /**
     * <code>uint32 target_uid = 5;</code>
     * @return The targetUid.
     */
    @java.lang.Override
    public int getTargetUid() {
      return targetUid_;
    }

    public static final int PULL_NUM_FIELD_NUMBER = 7;
    private int pullNum_;
    /**
     * <code>uint32 pull_num = 7;</code>
     * @return The pullNum.
     */
    @java.lang.Override
    public int getPullNum() {
      return pullNum_;
    }

    public static final int FROM_SEQUENCE_FIELD_NUMBER = 12;
    private int fromSequence_;
    /**
     * <code>uint32 from_sequence = 12;</code>
     * @return The fromSequence.
     */
    @java.lang.Override
    public int getFromSequence() {
      return fromSequence_;
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
      if (targetUid_ != 0) {
        output.writeUInt32(5, targetUid_);
      }
      if (pullNum_ != 0) {
        output.writeUInt32(7, pullNum_);
      }
      if (fromSequence_ != 0) {
        output.writeUInt32(12, fromSequence_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (targetUid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(5, targetUid_);
      }
      if (pullNum_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(7, pullNum_);
      }
      if (fromSequence_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(12, fromSequence_);
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
      if (!(obj instanceof emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq other = (emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq) obj;

      if (getTargetUid()
          != other.getTargetUid()) return false;
      if (getPullNum()
          != other.getPullNum()) return false;
      if (getFromSequence()
          != other.getFromSequence()) return false;
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
      hash = (37 * hash) + TARGET_UID_FIELD_NUMBER;
      hash = (53 * hash) + getTargetUid();
      hash = (37 * hash) + PULL_NUM_FIELD_NUMBER;
      hash = (53 * hash) + getPullNum();
      hash = (37 * hash) + FROM_SEQUENCE_FIELD_NUMBER;
      hash = (53 * hash) + getFromSequence();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq prototype) {
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
     * <pre>
     * CmdId: 4971
     * EnetChannelId: 0
     * EnetIsReliable: true
     * IsAllowClient: true
     * </pre>
     *
     * Protobuf type {@code PullPrivateChatReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PullPrivateChatReq)
        emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.class, emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.newBuilder()
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
        targetUid_ = 0;

        pullNum_ = 0;

        fromSequence_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq build() {
        emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq buildPartial() {
        emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq result = new emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq(this);
        result.targetUid_ = targetUid_;
        result.pullNum_ = pullNum_;
        result.fromSequence_ = fromSequence_;
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
        if (other instanceof emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq) {
          return mergeFrom((emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq other) {
        if (other == emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.getDefaultInstance()) return this;
        if (other.getTargetUid() != 0) {
          setTargetUid(other.getTargetUid());
        }
        if (other.getPullNum() != 0) {
          setPullNum(other.getPullNum());
        }
        if (other.getFromSequence() != 0) {
          setFromSequence(other.getFromSequence());
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
        emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int targetUid_ ;
      /**
       * <code>uint32 target_uid = 5;</code>
       * @return The targetUid.
       */
      @java.lang.Override
      public int getTargetUid() {
        return targetUid_;
      }
      /**
       * <code>uint32 target_uid = 5;</code>
       * @param value The targetUid to set.
       * @return This builder for chaining.
       */
      public Builder setTargetUid(int value) {
        
        targetUid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 target_uid = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearTargetUid() {
        
        targetUid_ = 0;
        onChanged();
        return this;
      }

      private int pullNum_ ;
      /**
       * <code>uint32 pull_num = 7;</code>
       * @return The pullNum.
       */
      @java.lang.Override
      public int getPullNum() {
        return pullNum_;
      }
      /**
       * <code>uint32 pull_num = 7;</code>
       * @param value The pullNum to set.
       * @return This builder for chaining.
       */
      public Builder setPullNum(int value) {
        
        pullNum_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 pull_num = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearPullNum() {
        
        pullNum_ = 0;
        onChanged();
        return this;
      }

      private int fromSequence_ ;
      /**
       * <code>uint32 from_sequence = 12;</code>
       * @return The fromSequence.
       */
      @java.lang.Override
      public int getFromSequence() {
        return fromSequence_;
      }
      /**
       * <code>uint32 from_sequence = 12;</code>
       * @param value The fromSequence to set.
       * @return This builder for chaining.
       */
      public Builder setFromSequence(int value) {
        
        fromSequence_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 from_sequence = 12;</code>
       * @return This builder for chaining.
       */
      public Builder clearFromSequence() {
        
        fromSequence_ = 0;
        onChanged();
        return this;
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


      // @@protoc_insertion_point(builder_scope:PullPrivateChatReq)
    }

    // @@protoc_insertion_point(class_scope:PullPrivateChatReq)
    private static final emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq();
    }

    public static emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PullPrivateChatReq>
        PARSER = new com.google.protobuf.AbstractParser<PullPrivateChatReq>() {
      @java.lang.Override
      public PullPrivateChatReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PullPrivateChatReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PullPrivateChatReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PullPrivateChatReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PullPrivateChatReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PullPrivateChatReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030PullPrivateChatReq.proto\"Q\n\022PullPrivat" +
      "eChatReq\022\022\n\ntarget_uid\030\005 \001(\r\022\020\n\010pull_num" +
      "\030\007 \001(\r\022\025\n\rfrom_sequence\030\014 \001(\rB\033\n\031emu.gra" +
      "sscutter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_PullPrivateChatReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PullPrivateChatReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PullPrivateChatReq_descriptor,
        new java.lang.String[] { "TargetUid", "PullNum", "FromSequence", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
