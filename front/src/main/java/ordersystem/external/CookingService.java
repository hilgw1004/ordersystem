package ordersystem.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "store", url = "${api.url.store}")
public interface CookingService {
    @RequestMapping(method = RequestMethod.POST, path = "/cookings")
    public void rejectOrder(@RequestBody Cooking cooking);
}
