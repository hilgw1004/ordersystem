package ordersystem.domain;

import java.util.*;
import lombok.*;
import ordersystem.domain.*;
import ordersystem.infra.AbstractEvent;

@Data
@ToString
public class Deliverydone extends AbstractEvent {

    private Long id;
    private String oderid;
    private String address;
    private String status;
    private String confirmid;
    private String riderid;

    public Deliverydone(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverydone() {
        super();
    }
}
