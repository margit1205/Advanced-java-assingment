package com.controller;

import com.model.Medicine;
import com.services.MedicineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    private static  final Logger logger = LoggerFactory.getLogger(com.controller.MedicineController.class);

    @GetMapping
    public List<Medicine> getMedicine(){
        logger.info("Medicine List");
        return  MedicineService.getMedicine();
    }
    @PostMapping("/create")
    public  Medicine createMedicine(@RequestBody Medicine medicine){
        logger.info("create Medicine is invoked{}",medicine);
        return  medicineService.create(medicine);
    }
    @GetMapping("{Id}")
    public Medicine getMedicineById(@PathVariable("id")int Id){
        logger.info("getMedicineById is invoked with Medicine Id : {}",Id);
        return medicineService.getMedicineById(Id);

    }
    @PutMapping("/update")
    public Medicine updateMedicine(@RequestBody Medicine medicine){
        return  medicineService.updateMedicine(medicine);

    }
    @DeleteMapping("/{Id}")
    public  Medicine deleteMedicineById(@PathVariable("Id") int Id){
        return  medicineService.deleteMedicine(Id);
    }

}
