package com.sasanka.authorizationserver.service;

import com.sasanka.authorizationserver.model.AuthUserDetail;
import com.sasanka.authorizationserver.model.User;
import com.sasanka.authorizationserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDetailRepository.findByUsername(username);
        user.orElseThrow(()->new UsernameNotFoundException(username+" is not found"));

        UserDetails userDetails = new AuthUserDetail(user.get());

        new AccountStatusUserDetailsChecker().check(userDetails); //if false this will throw an exception

        return userDetails;
    }
}
