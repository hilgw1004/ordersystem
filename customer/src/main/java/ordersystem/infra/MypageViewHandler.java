package ordersystem.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import ordersystem.config.kafka.KafkaProcessor;
import ordersystem.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MypageViewHandler {

    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverydone_then_CREATE_1(
        @Payload Deliverydone deliverydone
    ) {
        try {
            if (!deliverydone.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setId(deliverydone.getId());
            mypage.setCustomerid(deliverydone.getCustomerid());
            mypage.setFoodid(deliverydone.getFoodid());
            mypage.setOderid(deliverydone.getOrderid());
            mypage.setStatus(deliverydone.getStatus());
            mypage.setFoodname(deliverydone.getFoodname());
            mypage.setAddress(deliverydone.getAddress());
            mypage.setRiderid(deliverydone.getRiderid());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryoderaccepted_then_UPDATE_1(
        @Payload Deliveryoderaccepted deliveryoderaccepted
    ) {
        try {
            if (!deliveryoderaccepted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
