package ca.pledgetovote.controllers;

import ca.pledgetovote.service.PledgeService;
import ca.pledgetovote.model.Pledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("pledgeController")
public class PledgeController {
    private List<Pledge> pledges = new ArrayList<>();
    //private AtomicLong nextId = new AtomicLong();

    @Autowired
            @Qualifier("pledgeServiceRepository")
    PledgeService pledgeService;

    @GetMapping("/hello")
    public String getHelloMessage(){
        return "Hello Spring Boot world!";
    }

    @PostMapping("/pledges")
    @ResponseStatus(HttpStatus.CREATED)
    //if using x-www-form-urlencoded input (with postman for example) removeD the @RequestBody annotation
    public Pledge createNewPledge(@RequestBody Pledge pledge){
        //Set pledge to have next id
        return pledgeService.createPledge(pledge);
    }

    @GetMapping("/pledges")
    public List<Pledge> getAllPledges(){
        return pledgeService.getAllPledges();
    }

    @GetMapping("/pledges/{id}")
    public Pledge getOnePledge(@PathVariable("id") long pledgeId){
        return pledgeService.getPledgeById(pledgeId);
    }

    @PutMapping("/pledges/{id}")
    public Pledge editOnePledge(@PathVariable("id") long pledgeId,
                                @RequestBody Pledge newPledge) {
        return pledgeService.updatePledge(pledgeId, newPledge);
    }

    @DeleteMapping("/pledges/{id}")
    public void removePledgeById(@PathVariable("id") long pledgeId){
        pledgeService.deletePledgeById(pledgeId);
    }

    // Create Exception handler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //Nothing to do
    }

}
