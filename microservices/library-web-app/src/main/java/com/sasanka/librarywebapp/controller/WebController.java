package com.sasanka.librarywebapp.controller;

import com.sasanka.librarywebapp.config.AccessToken;
import commons.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableOAuth2Sso //with this the ui knows it need to authenticate from auth server
public class WebController extends WebSecurityConfigurerAdapter {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //all the requests have to be authorized. However request matching for '/' path permit all. Any other request has to authenticate
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
    }

    @RequestMapping(value = "/")
    public String loadUI(){
        return "home";
    }

    @RequestMapping(value = "/secure")
    public String loadSecureUI(){
        return "secure";
    }

    @RequestMapping(value = "/customers")
    public String loadCustomers(Model model){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AccessToken.getAccesstoken());
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(headers);

        //exception handling
        try {
            ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://localhost:9191/profile/find", HttpMethod.GET,customerHttpEntity,Customer[].class);
            model.addAttribute("customers",responseEntity.getBody());
        }catch (HttpStatusCodeException e){
            ResponseEntity responseEntity = ResponseEntity.status(e.getStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }
        return "secure";
    }
}
