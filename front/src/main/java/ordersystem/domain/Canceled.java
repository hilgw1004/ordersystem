package ordersystem.domain;

import java.util.*;
import lombok.*;
import ordersystem.domain.*;
import ordersystem.infra.AbstractEvent;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String storeid;
    private String customerid;
    private String foodid;
    private String address;
    private String status;
    private String foodname;

    public Canceled(Order aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
