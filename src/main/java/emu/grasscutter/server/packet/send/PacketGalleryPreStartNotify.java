package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.GalleryPreStartNotify;

public class PacketGalleryPreStartNotify extends BaseTypedPacket<GalleryPreStartNotify> {

    public PacketGalleryPreStartNotify(int galleryId, int startTime) {
        super(new GalleryPreStartNotify());
        proto.setGalleryId(galleryId);
        proto.setPreStartEndTime(startTime);
    }

}
