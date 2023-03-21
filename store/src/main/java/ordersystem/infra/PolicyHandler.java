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

    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_OrderConfirm(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener OrderConfirm : " + paid + "\n\n"
        );

        // Sample Logic //
        Cooking.orderConfirm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paybacked'"
    )
    public void wheneverPaybacked_UpdateStatus(@Payload Paybacked paybacked) {
        Paybacked event = paybacked;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + paybacked + "\n\n"
        );

        // Sample Logic //
        Cooking.updateStatus(event);
    }
}
