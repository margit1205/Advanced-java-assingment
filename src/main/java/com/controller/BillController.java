package com.controller;

import com.model.Bill;
import com.services.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/bill")
public class BillController {


        @Autowired
        BillService billService;

        private static  final Logger logger = LoggerFactory.getLogger(com.controller.BillController.class);

        @GetMapping
        public List<Bill> getBill(){
            logger.info("Bill List");
            return  billService.getBill();
        }
        @PostMapping("/create")
        public  Bill createBill(@RequestBody Bill bill){
            logger.info("create Bill is invoked{}",bill);
            return  billService.create(bill);
        }
        @GetMapping("{Id}")
        public  Bill getBillById(@PathVariable("Id")int Id){
            logger.info("getBillById is invoked with bill Id : {}",Id);
            return billService.getBillById(Id);

        }
        @PutMapping("/update")
        public Bill updateBill(@RequestBody Bill bill){
            return   billService.updateBill(bill);

        }
        @DeleteMapping("/{Id}")
        public  Bill deleteBillById(@PathVariable("Id") int Id){
            return  billService.deleteBill(Id);
        }



    }
