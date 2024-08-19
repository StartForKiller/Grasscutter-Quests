package emu.grasscutter.server.packet.send;

import org.anime_game_servers.multi_proto.gi.messages.gallery.GalleryStartNotify;

import emu.grasscutter.net.packet.BaseTypedPacket;

public class PacketGalleryStartNotify extends BaseTypedPacket<GalleryStartNotify> {

    public PacketGalleryStartNotify(int galleryId, int startTime, int duration, int ownerUid) {
        super(new GalleryStartNotify());
        proto.setGalleryId(galleryId);
        proto.setStartTime(startTime);
        proto.setEndTime(startTime + duration);
        proto.setOwnerUid(ownerUid);
    }

}
