package com.way2Job.jobportal.services;

import com.way2Job.jobportal.entity.Users;
import com.way2Job.jobportal.repository.UsersRepository;
import com.way2Job.jobportal.util.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not found user"));

        return new CustomUserDetails(user);
    }
}