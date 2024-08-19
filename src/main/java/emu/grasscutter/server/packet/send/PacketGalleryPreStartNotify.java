package emu.grasscutter.server.packet.send;

import org.anime_game_servers.multi_proto.gi.messages.gallery.GalleryPreStartNotify;

import emu.grasscutter.net.packet.BaseTypedPacket;

public class PacketGalleryPreStartNotify extends BaseTypedPacket<GalleryPreStartNotify> {

    public PacketGalleryPreStartNotify(int galleryId, int startTime) {
        super(new GalleryPreStartNotify());
        proto.setGalleryId(galleryId);
        proto.setPreStartEndTime(startTime);
    }

}
