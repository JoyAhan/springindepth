package com.ahan.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ahan.Invoice;
import com.ahan.context.Application;
import com.ahan.model.User;

public class InvoiceService {

	List<Invoice> invoices = new CopyOnWriteArrayList<>(); // (1)
	private final UserService userService;
	
	public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
    	
    	User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }
        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

}
