package emu.grasscutter.data.binout.routes;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Route {
    private int localId;
    private String name;
    private RouteType type = RouteType.Unknown;
    private RoutePoint[] points;
    private float arriveRange; // optional
    private RotType rotType; // optional
    private RotAngleType rotAngleType; // optional

    public messages.scene.entity.Route toProto(){
        val protoPoints = points == null? new ArrayList<messages.general.RoutePoint>() :
            Arrays.stream(points).map(RoutePoint::toProto).toList();
        return new messages.scene.entity.Route(protoPoints, type.getValue());
    }
}
