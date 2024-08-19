package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import org.anime_game_servers.multi_proto.gi.messages.scene.weather.SceneWeatherForecastRsp;

import java.util.List;

public class PacketSceneWeatherForcastRsp extends BaseTypedPacket<SceneWeatherForecastRsp> {

    public PacketSceneWeatherForcastRsp(List<Integer> forcastList) {
        super(new SceneWeatherForecastRsp());

        proto.setForecastClimateList(forcastList);
    }

    public PacketSceneWeatherForcastRsp(int retcode) {
        super(new SceneWeatherForecastRsp());

        proto.setRetcode(retcode);
    }

}
