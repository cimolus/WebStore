package com.kassirov.webstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kassirov.domain.Comment;
import com.kassirov.services.ProductService;

@Controller
public class FindController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FindController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/get/product/", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("listOfProducts");
		mav.addObject("products", productService.getAllProducts());
		return mav;
	}
	
	@RequestMapping(value="/get/product/{id}", method = RequestMethod.GET)
	public ModelAndView getProductById(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("detaileProduct");
		mav.addObject("product", productService.getProductById(id));
		mav.addObject("Comment",new Comment(id));
		return mav;	
	}
	
	@RequestMapping(value = "/search/page", method = RequestMethod.GET)
	public String getSearchPage() {
		return "searchPage";
	}
	
	@RequestMapping(value = "/search/{pattern}", method = RequestMethod.GET)
	public ModelAndView searchOfProducts(@PathVariable String pattern ) {
		ModelAndView mav = new ModelAndView("listOfProducts");
		mav.addObject("products", productService.getSearchingProducts(pattern));
		return mav;
	}
	
	@RequestMapping(value="/get/product/rating/{count}", method = RequestMethod.GET) 
	public ModelAndView getRatingProducts(@PathVariable int count ) {
		return new ModelAndView("slides", "products", productService.getRatingProducts(count));
	}
	
}
