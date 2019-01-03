package com.micro.authservice.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.micro.authservice.db.AppUser;
import com.micro.authservice.db.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AppUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = repository.findByUsername(username);
		
		if (appUser.getUsername() == null) {
			// If user not found. Throw this exception.
			throw new UsernameNotFoundException("Username: " + username + " not found");
		}

				
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                	.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
		return new User(appUser.getUsername(), encoder.encode(appUser.getPassword()), grantedAuthorities);
		
		
	}
}