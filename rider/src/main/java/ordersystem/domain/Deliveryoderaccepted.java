package ordersystem.domain;

import java.util.*;
import lombok.*;
import ordersystem.domain.*;
import ordersystem.infra.AbstractEvent;

@Data
@ToString
public class Deliveryoderaccepted extends AbstractEvent {

    private Long id;
    private String oderid;
    private String address;
    private String status;
    private String confirmid;
    private String riderid;

    public Deliveryoderaccepted(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveryoderaccepted() {
        super();
    }
}
