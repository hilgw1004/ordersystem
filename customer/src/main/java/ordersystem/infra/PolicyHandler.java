package ordersystem.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ordersystem.config.kafka.KafkaProcessor;
import ordersystem.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverydone'"
    )
    public void wheneverDeliverydone_Notify(
        @Payload Deliverydone deliverydone
    ) {
        Deliverydone event = deliverydone;
        System.out.println(
            "\n\n##### listener Notify : " + deliverydone + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliveryoderaccepted'"
    )
    public void wheneverDeliveryoderaccepted_Notify(
        @Payload Deliveryoderaccepted deliveryoderaccepted
    ) {
        Deliveryoderaccepted event = deliveryoderaccepted;
        System.out.println(
            "\n\n##### listener Notify : " + deliveryoderaccepted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderrejected'"
    )
    public void wheneverOrderrejected_Notify(
        @Payload Orderrejected orderrejected
    ) {
        Orderrejected event = orderrejected;
        System.out.println(
            "\n\n##### listener Notify : " + orderrejected + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookstarted'"
    )
    public void wheneverCookstarted_Notify(@Payload Cookstarted cookstarted) {
        Cookstarted event = cookstarted;
        System.out.println(
            "\n\n##### listener Notify : " + cookstarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookfinished'"
    )
    public void wheneverCookfinished_Notify(
        @Payload Cookfinished cookfinished
    ) {
        Cookfinished event = cookfinished;
        System.out.println(
            "\n\n##### listener Notify : " + cookfinished + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paybacked'"
    )
    public void wheneverPaybacked_Notify(@Payload Paybacked paybacked) {
        Paybacked event = paybacked;
        System.out.println("\n\n##### listener Notify : " + paybacked + "\n\n");
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_Notify(@Payload Paid paid) {
        Paid event = paid;
        System.out.println("\n\n##### listener Notify : " + paid + "\n\n");
        // Sample Logic //

    }
}
