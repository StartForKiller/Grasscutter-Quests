package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.SceneGalleryInfo;
import messages.gallery.SceneGalleryInfoNotify;

public class PacketSceneGalleryInfoNotify extends BaseTypedPacket<SceneGalleryInfoNotify> {

    public PacketSceneGalleryInfoNotify(SceneGalleryInfo info) {
        super(new SceneGalleryInfoNotify());
        proto.setGalleryInfo(info);
    }

}
