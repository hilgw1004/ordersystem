package ordersystem.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ordersystem.StoreApplication;
import ordersystem.domain.Cookfinished;
import ordersystem.domain.Cookstarted;
import ordersystem.domain.Orderrejected;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodid;

    private String orderid;

    private String customerid;

    private String address;

    private String status;

    private String foodname;

    private String riderpickup;

    private String riderid;

    @PostPersist
    public void onPostPersist() {
        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();

        Cookfinished cookfinished = new Cookfinished(this);
        cookfinished.publishAfterCommit();

        Orderrejected orderrejected = new Orderrejected(this);
        orderrejected.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public static void orderConfirm(Paid paid) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }

    public static void updateStatus(Paybacked paybacked) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(paybacked.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
