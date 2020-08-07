package com.spring.henallux.javawebproject.dataAccess.entity;

import com.spring.henallux.javawebproject.utility.UtilAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "authorities")
	private String authorities;
	@Column(name = "non_expired")
	private Boolean accountNonExpired;
	@Column(name = "non_locked")
	private Boolean accountNonLocked;
	@Column(name = "credentials_non_expired")
	private Boolean credentialsNonExpired;
	@Column(name = "enable")
	private Boolean enable;

	@Column(name = "name")
	private String name;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "postal_code")
	private String postalCode;
	@Column(name = "city")
	private String city;
	@Column(name = "address")
	private String address;
	@Column(name = "gender")
	private String gender;
	@Column(name = "birth_date")
	private Date birthDate;

	@OneToMany(mappedBy = "customer")
	private Collection<OrderEntity> orders;

	public UserEntity() {

	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return UtilAuthority.getAuthorities(authorities);
	}

	//Setters section
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(Character gender) {
		this.gender = gender.toString();
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setOrders(Collection<OrderEntity> orders) {
		this.orders = orders;
	}

	//Getters section
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

	public Boolean getEnabled() {
		return enable;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public Collection<OrderEntity> getOrders() {
		return orders;
	}
}
