package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.GalleryStartNotify;

public class PacketGalleryStartNotify extends BaseTypedPacket<GalleryStartNotify> {

    public PacketGalleryStartNotify(int galleryId, int startTime, int duration, int ownerUid) {
        super(new GalleryStartNotify());
        proto.setGalleryId(galleryId);
        proto.setStartTime(startTime);
        proto.setEndTime(startTime + duration);
        proto.setOwnerUid(ownerUid);
    }

}
