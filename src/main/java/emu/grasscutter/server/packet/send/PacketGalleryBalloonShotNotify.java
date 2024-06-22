package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.GalleryBalloonShootNotify;

public class PacketGalleryBalloonShotNotify extends BaseTypedPacket<GalleryBalloonShootNotify> {

    public PacketGalleryBalloonShotNotify(int galleryId, int addScore, int combo, long comboDisableTime, int curScore, int triggerEntityId) {
        super(new GalleryBalloonShootNotify(galleryId, addScore, combo, comboDisableTime, curScore, triggerEntityId));
    }

}
