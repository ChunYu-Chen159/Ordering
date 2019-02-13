package Ordering;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Api(value = "OrderingController", tags = "與購買相關的電影與雜物都在這裡")
@RestController
public class OrderingController {
	@Autowired
	
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String index() 
    {
		return "success";
    }
	
	@ApiOperation(value = "將購買電影加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newMovieOrdering(@RequestParam("moviesID") String moviesID)
    {
    	return Ordering.newMovieOrdering(moviesID);
    }
	
	@ApiOperation(value = "將購買的周邊商品加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newGroceryOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@RequestParam("groceryID") String groceryID, @RequestParam("quantity") String quantity)
    {
    	return Ordering.newGroceryOrdering(groceryID, quantity);
    }
	
	@ApiOperation(value = "透過userID得到已購買電影的ID", notes = "回傳已購買電影ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getMovieFromOrderList", method = RequestMethod.GET)
    public String getMovieFromOrderList(@RequestParam("userID") String userID)
    {
    	return Ordering.getMovieFromOrderList(userID);
    }
	
	@ApiOperation(value = "透過userID得到已購買周邊的ID", notes = "回傳已購買周邊ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getGroceryFromOrderList", method = RequestMethod.GET)
    public String getGroceryFromOrderList(@RequestParam("userID") String userID)
    {
    	return Ordering.getGroceryFromOrderList(userID);
    }
	
	@ApiOperation(value = "將訊息加入資料庫中", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "notification", method = RequestMethod.GET)
    public String notification(@RequestParam("userID") String userID, @RequestParam("content") String content)
    {
		try {  
			return Ordering.notification(userID, URLEncoder.encode(content, "UTF-8"));
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return "{}";
        }
    	
    }
	
	@ApiOperation(value = "結帳", notes = "成功結帳就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "payment", method = RequestMethod.GET)
    public String payment(@RequestParam("userID") String userID, @RequestParam("price") String price)
    {
    	return Ordering.payment(userID, price);
    }
	
	
}
