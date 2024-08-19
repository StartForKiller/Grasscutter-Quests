package emu.grasscutter.server.packet.send;

import org.anime_game_servers.multi_proto.gi.messages.gallery.GalleryStopNotify;

import emu.grasscutter.net.packet.BaseTypedPacket;

public class PacketGalleryStopNotify extends BaseTypedPacket<GalleryStopNotify> {

    public PacketGalleryStopNotify(int galleryId) {
        super(new GalleryStopNotify());
        proto.setGalleryId(galleryId);
    }

}
