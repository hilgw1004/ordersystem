package ordersystem.external;

import java.util.Date;
import lombok.Data;

@Data
public class Cooking {

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
