package com.controller;

import com.model.Orderlist;
import com.services.OrderlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/orderlist")
public class orderlistController {
    @Autowired
    OrderlistService orderlistService;

    private static  final Logger logger = LoggerFactory.getLogger(com.controller.orderlistController.class);

    @GetMapping
    public List<Orderlist> getOrderlist(){
        logger.info("Orderlist List");
        return  orderlistService.getOrderlist();
    }
    @PostMapping("/create")
    public Orderlist createOrderlist(@RequestBody Orderlist orderlist){
        logger.info("create Orderlist is invoked{}",orderlist);
        return orderlistService.create(orderlist);
    }
    @GetMapping("{Id}")
    public Orderlist getOrderlistById(@PathVariable("id")int Id){
        logger.info("getOrderlistById is invoked with Orderlist Id : {}",Id);
        return orderlistService.getOrderlistById(Id);

    }
    @PutMapping("/update")
    public Orderlist updateOrderlist(@RequestBody Orderlist orderlist){
        return  orderlistService.updateOrderlist(orderlist);

    }
    @DeleteMapping("/{Id}")
    public  Orderlist deleteOrderlistById(@PathVariable("Id") int Id){
        return  orderlistService.deleteOrderlist(Id);
    }

}
