package ordersystem.domain;

import java.util.*;
import lombok.*;
import ordersystem.domain.*;
import ordersystem.infra.AbstractEvent;

@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long id;
    private String foodid;
    private String orderid;
    private String customerid;
    private String address;
    private String status;
    private String foodname;
    private String riderpickup;
    private String riderid;
}
