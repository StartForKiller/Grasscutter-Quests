package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;

import java.util.Map;

import org.anime_game_servers.multi_proto.gi.messages.gallery.balloon.GalleryBalloonScoreNotify;

public class PacketGalleryBalloonScoreNotify extends BaseTypedPacket<GalleryBalloonScoreNotify> {

    public PacketGalleryBalloonScoreNotify(int galleryId, Map<Integer, Integer> scoreMap) {
        super(new GalleryBalloonScoreNotify(galleryId, scoreMap));
    }

}
