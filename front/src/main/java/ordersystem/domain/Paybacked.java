package ordersystem.domain;

import java.util.*;
import lombok.*;
import ordersystem.domain.*;
import ordersystem.infra.AbstractEvent;

@Data
@ToString
public class Paybacked extends AbstractEvent {

    private Long id;
    private String status;
    private String customerid;
    private String orderid;
    private String cacelid;

    public Paybacked(Payment aggregate) {
        super(aggregate);
    }

    public Paybacked() {
        super();
    }
}
