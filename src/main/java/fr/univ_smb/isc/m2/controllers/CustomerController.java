package fr.univ_smb.isc.m2.controllers;

import fr.univ_smb.isc.m2.domain.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

@RestController
public class CustomerController {

    private final ArrayList<Customer> customers;

    public CustomerController() {
        customers = new ArrayList<>();
        customers.add(new Customer("Ritchie", "Blackmore"));
        customers.add(new Customer("Jon", "Lord"));
        customers.add(new Customer("Ian", "Paice"));
        customers.add(new Customer("Rod", "Evans"));
        customers.add(new Customer("Nick", "Simper"));
    }


    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> customer() {
        return customers;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer customer(@PathVariable String id) {

        List<Customer> collect = customers.stream().filter(u -> u.id == parseInt(id)).collect(toList());

        if (!collect.isEmpty()) {
            return collect.get(0);
        }

        throw new ResourceNotFoundException();

    }

}
