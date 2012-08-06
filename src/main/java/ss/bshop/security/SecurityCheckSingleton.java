
package ss.bshop.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityCheckSingleton {

	public volatile static SecurityCheckSingleton instance;

	private SecurityCheckSingleton() {
	}

	public static SecurityCheckSingleton getInstance() {
		if (instance == null) {
			synchronized (SecurityCheckSingleton.class) {
				if (instance == null) {
					instance = new SecurityCheckSingleton();
				}
			}
		}
		return instance;
	}

	/**
	 * Checks current user credentials
	 * 
	 * @param roles
	 *            role names
	 * @return if user has role - returns true
	 */
	public boolean hasAnyRole(String... roles) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Collection<GrantedAuthority> authorities = authentication
				.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			for (String role : roles) {
				if (role.equals(authority.getAuthority())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<String> getRoles() {
		ArrayList<String> roles = new ArrayList<String>();
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Collection<GrantedAuthority> authorities = authentication
				.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			roles.add(authority.getAuthority());
		}
		return roles;
	}
	
	public String getLogin() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		return authentication.getName();
	}
	
}
