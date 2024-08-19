package emu.grasscutter.server.packet.send;

import org.anime_game_servers.multi_proto.gi.messages.gallery.SceneGalleryInfo;
import org.anime_game_servers.multi_proto.gi.messages.gallery.SceneGalleryInfoNotify;

import emu.grasscutter.net.packet.BaseTypedPacket;

public class PacketSceneGalleryInfoNotify extends BaseTypedPacket<SceneGalleryInfoNotify> {

    public PacketSceneGalleryInfoNotify(SceneGalleryInfo info) {
        super(new SceneGalleryInfoNotify());
        proto.setGalleryInfo(info);
    }

}
