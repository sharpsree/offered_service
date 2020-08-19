package com.vms.offeredservice.service;

import com.vms.offeredservice.configuration.CustomUserDetails;
import com.vms.offeredservice.entity.User;
import com.vms.offeredservice.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails loadUserByUsername(String Vehicleid) throws UsernameNotFoundException {
        Optional<User> optioanlUser = userDetailsRepository.findById(Integer.parseInt(Vehicleid));
        if(!optioanlUser.isPresent()){
            log.error("specified user not found");
        }
        optioanlUser.orElseThrow(()->new UsernameNotFoundException("user not found"));
        return optioanlUser.map(CustomUserDetails::new).get();
    }
}
