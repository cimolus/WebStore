package com.kassirov.webstore;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kassirov.domain.Basket;
import com.kassirov.domain.Order;
import com.kassirov.domain.User;
import com.kassirov.services.OrderService;
import com.kassirov.services.ProductService;


@Controller
@RequestMapping("/basket")
public class BasketController {
	
	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/add/{id}")
	public String addProductToBasket(@PathVariable int id, HttpSession session ) {
		Basket basket = getBasket(session);
		basket.addProduct(productService.getProductById(id));
		session.setAttribute("basket", basket);
		return "redirect:/get/product/" + id;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProductFromBasket(@PathVariable int id,HttpSession session) {
		Basket basket = getBasket(session);
		basket.dropProduct(id);
		session.setAttribute("basket", basket);
		return "redirect:/get/product/" + id;
	}
	
	@RequestMapping("/getproducts")
	public String getProductsInBasket(HttpSession session, Model model) {
		Basket basket = getBasket(session);
		model.addAttribute("products", productService.getProducts(basket.getProducts()));
		return "productsInBasket";
	}
	
	@RequestMapping("/orderPage") 
	public String orderPage(Model model, HttpSession session) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if ( getBasket(session).size() == 0 )
			return "home";
		model.addAttribute("Order", new Order());
		model.addAttribute("username", user.getUsername());
		return "orderPage";
	}
	
	@RequestMapping(value="/order", method = RequestMethod.POST)
	public String orderProductsFromBasket(@ModelAttribute("Order") Order order, HttpSession session) {
		order.setDelivered(false);
		order.setPaid(false);
		Basket basket = getBasket(session);
		order.setOrderedProducts(basket.getProducts());
		orderService.addOrder(order);
		basket.clearBasket();
		session.setAttribute("basket", basket);
		return "paymentPage";
	}
	
	private Basket getBasket(HttpSession session) {
		Basket basket = (Basket) session.getAttribute("basket");
		if( basket == null )
			basket = new Basket();
		return basket;
	}
	
}
