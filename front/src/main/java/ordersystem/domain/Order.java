package ordersystem.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ordersystem.FrontApplication;
import ordersystem.domain.Canceled;
import ordersystem.domain.Oredered;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeid;

    private String customerid;

    private String foodid;

    private String address;

    private String status;

    private String foodname;

    @PostPersist
    public void onPostPersist() {
        Oredered oredered = new Oredered(this);
        oredered.publishAfterCommit();

        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
