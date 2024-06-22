package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.GalleryStopNotify;

public class PacketGalleryStopNotify extends BaseTypedPacket<GalleryStopNotify> {

    public PacketGalleryStopNotify(int galleryId) {
        super(new GalleryStopNotify());
        proto.setGalleryId(galleryId);
    }

}
