package fr.univ_smb.isc.m2.controllers.rest;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.customer.Customer;
import fr.univ_smb.isc.m2.domain.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class RestCustomerController {

    private final CustomerService customerService;

    @Autowired()
    public RestCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(value = "/customers", method = GET, produces = "application/json;charset=UTF-8")
    public List<Customer> customer() {
        return customerService.all();
    }

    @RequestMapping(value = "/customers/{id}", method = GET, produces = "application/json;charset=UTF-8")
    public Customer customer(@PathVariable String id) {
        int customerId = parseInt(id);
        Customer customer = customerService.selectById(customerId);
        return Optional.ofNullable(customer).orElseThrow(ResourceNotFoundException::new);
    }

}
