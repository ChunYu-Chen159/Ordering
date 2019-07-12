package Ordering;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment")
public interface PaymentInterface {

//	@RequestMapping(value = "/notification/newNotification", method = RequestMethod.GET)
//    String notification(@RequestParam("userID") String userID, @RequestParam("content") String content);

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    String payment();




	/*
    @GetMapping("/notification/newNotification")
    String notification(@PathVariable("userID") String userID, @PathVariable("content") String content);

    @GetMapping("/payment")
    String payment();
	 */
}