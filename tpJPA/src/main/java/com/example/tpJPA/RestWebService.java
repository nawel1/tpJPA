package com.example.tpJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**

@RestController
public class RestWebService {

    VehiculeRepositry vehiculeRepositry;

    @Autowired
    public RestWebService(VehiculeRepositry vehiculeRepositry) {
        super();
        this.vehiculeRepositry = vehiculeRepositry;
    }

    @GetMapping("/vehicules")
    public Iterable<Vehicule> getVehicules(){
        return vehiculeRepositry.findAll();
    }

    @PostMapping("/vehicules")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addCity(@RequestBody Vehicule vehicule) throws Exception {
        vehiculeRepositry.save(vehicule);
        if(vehicule.getPlateNumber().equals("platenumbertest")){
            throw new Exception();
        }
    }
}

 *
 */
