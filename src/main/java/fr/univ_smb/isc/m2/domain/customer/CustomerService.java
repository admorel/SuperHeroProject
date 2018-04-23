package fr.univ_smb.isc.m2.domain.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CustomerService {

    private final ArrayList<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer("Ritchie", "Blackmore"));
        customers.add(new Customer("Jon", "Lord"));
        customers.add(new Customer("Ian", "Paice"));
        customers.add(new Customer("Rod", "Evans"));
        customers.add(new Customer("Nick", "Simper"));
        customers.add(new Customer("Charles", "Xavier"));
    }

    public List<Customer> all() {
        return customers;
    }

    public Customer selectById(int customerId) {
        List<Customer> collect = customers.stream()
                .filter(u -> u.id == customerId)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }

    public Customer create(String lastName, String firstName) {
        Customer customer = new Customer(firstName, lastName);
        customers.add(customer);
        return customer;
    }
}
