package ordersystem.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String customerid;
    private String foodid;
    private String oderid;
    private String status;
    private String foodname;
    private String address;
    private String riderid;
}
