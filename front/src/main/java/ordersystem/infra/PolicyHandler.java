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
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Oredered'"
    )
    public void wheneverOredered_Pay(@Payload Oredered oredered) {
        Oredered event = oredered;
        System.out.println("\n\n##### listener Pay : " + oredered + "\n\n");

        // Sample Logic //
        Payment.pay(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceled'"
    )
    public void wheneverCanceled_Payback(@Payload Canceled canceled) {
        Canceled event = canceled;
        System.out.println("\n\n##### listener Payback : " + canceled + "\n\n");

        // Sample Logic //
        Payment.payback(event);
    }
}
