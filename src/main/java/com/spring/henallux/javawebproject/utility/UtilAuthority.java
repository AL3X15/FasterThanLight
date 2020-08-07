package com.spring.henallux.javawebproject.utility;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class UtilAuthority {
	public static Collection<GrantedAuthority> getAuthorities(String authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		if (!isEmpty(authorities)) {
			String[] authoritiesAsArray = authorities.split(",");

			for (String authority : authoritiesAsArray) {
				if (!isEmpty(authority)) {
					grantedAuthorities.add(new SimpleGrantedAuthority(authority));
				}
			}
		}

		return grantedAuthorities;
	}
}
