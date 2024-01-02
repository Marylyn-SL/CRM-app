package com.example.crm.Service;

import com.example.crm.Model.Employee;
import com.example.crm.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class EmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if(employee != null) {
            String userName = employee.getUsername();
            String password = employee.getPassword();
            return new org.springframework.security.core.userdetails.User(
                employee.getUsername(), employee.getPassword(), mapRolesToAuthorities(employee.getRole())
            );
        }
        else {
            throw new UsernameNotFoundException("Invalid username");
        }
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        Collection<String> roles = new ArrayList<>();
        roles.add(role);
        Collection<? extends GrantedAuthority> mapRoles = roles.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
        return mapRoles;
    }
}
