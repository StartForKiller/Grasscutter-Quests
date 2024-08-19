package emu.grasscutter.server.packet.send;

import org.anime_game_servers.multi_proto.gi.messages.gallery.balloon.GalleryBalloonShootNotify;

import emu.grasscutter.net.packet.BaseTypedPacket;

public class PacketGalleryBalloonShotNotify extends BaseTypedPacket<GalleryBalloonShootNotify> {

    public PacketGalleryBalloonShotNotify(int galleryId, int addScore, int combo, long comboDisableTime, int curScore, int triggerEntityId) {
        super(new GalleryBalloonShootNotify(addScore, combo, comboDisableTime, curScore, galleryId, triggerEntityId));
    }

}
