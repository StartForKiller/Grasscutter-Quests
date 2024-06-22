package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.GalleryBalloonScoreNotify;

import java.util.Map;

public class PacketGalleryBalloonScoreNotify extends BaseTypedPacket<GalleryBalloonScoreNotify> {

    public PacketGalleryBalloonScoreNotify(int galleryId, Map<Integer, Integer> scoreMap) {
        super(new GalleryBalloonScoreNotify(galleryId, scoreMap));
    }

}
