package ordersystem.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ordersystem.RiderApplication;
import ordersystem.domain.Deliverydone;
import ordersystem.domain.Deliveryoderaccepted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String oderid;

    private String address;

    private String status;

    private String confirmid;

    private String riderid;

    @PostPersist
    public void onPostPersist() {
        Deliveryoderaccepted deliveryoderaccepted = new Deliveryoderaccepted(
            this
        );
        deliveryoderaccepted.publishAfterCommit();

        Deliverydone deliverydone = new Deliverydone(this);
        deliverydone.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void riderPickup(Cookstarted cookstarted) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookstarted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }

    public static void riderPickup(Cookfinished cookfinished) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
}
