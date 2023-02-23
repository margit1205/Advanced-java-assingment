package com.controller;

import com.model.Prescription;
import com.services.PrescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    private static  final Logger logger = LoggerFactory.getLogger(com.controller.PrescriptionController.class);

    @GetMapping
    public List<Prescription> getPrescription(){
        logger.info("Prescription List");
        return prescriptionService.getPrescription();
    }
    @PostMapping("/create")
    public  Prescription createPrescription(@RequestBody Prescription prescription){
        logger.info("create Prescription is invoked{}",prescription);
        return prescriptionService.create(prescription);
    }
    @GetMapping("{Id}")
    public  Prescription getPrescriptionById(@PathVariable("Id")int Id){
        logger.info("getPrescriptionById is invoked with bill Id : {}",Id);
        return prescriptionService.getPrescriptionById(Id);

    }
    @PutMapping("/update")
    public Prescription updatePrescription(@RequestBody Prescription prescription){
        return   PrescriptionService.updatePrescription(prescription);

    }
    @DeleteMapping("/{Id}")
    public  Prescription deletePrescriptionById(@PathVariable("Id") int Id){
        return  prescriptionService.deletePrescription(Id);
    }

}
