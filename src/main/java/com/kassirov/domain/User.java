package com.kassirov.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="users")
public class User implements UserDetails {
	
	private static final long serialVersionUID = -6135570791086338446L;

	@Id
	@Column(name="login")
	private String username;
	
	@Column(name="password")
	private String password;
	
	//private List<GrantedAuthority> authorities;
	@Column(name="user_role")
	private String authorities;
	
	@Column(name="active")
	private int active;
	
	public boolean isActive() {
		return (active > 0); 
	}
	
	public void setActive(boolean active) {
		this.active = active ? 1 : 0;
	}
	
	@SuppressWarnings("serial")
	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		String[] temp = this.authorities.split(",");
		for(final String s:temp) {
			authorities.add(new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return s;
				}
			});
		}
		return authorities;
	}
	
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
