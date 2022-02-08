package com.infinite.publisher.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.publisher.model.LineItem;
import com.infinite.publisher.repository.LineItemsRepository;

@RestController
@RequestMapping(value =  "/rest/LineItems")
public class LineItemsResource{
	 	@Autowired
	    LineItemsRepository lineItemsRepository;
	
	@GetMapping(value = "/")
    public java.util.List<LineItem> getAll() {
        return lineItemsRepository.findAll();
    }

    @PostMapping(value = "/load")
    public java.util.List<LineItem> persist(@RequestBody final LineItem lineItems) {
        lineItemsRepository.save(lineItems);
        return lineItemsRepository.findAll();
        
    }
	

}
