package com.ahan.context;

import com.ahan.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Application {

	public static final UserService userService = new UserService();
    public static final com.ahan.services.InvoiceService invoiceService = new com.ahan.services.InvoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();
    

}