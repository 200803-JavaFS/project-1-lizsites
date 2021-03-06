package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ers_users", schema="public")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class ERSUser implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ers_users_id")
	private int userId;
	
	
	@Column(name="ers_username", nullable=false, unique=true)
	private String username;
	
	@Column(name="ers_password", nullable=false)
	private String password;
	
	@Column(name="user_first_name")
	private String firstName;
	
	@Column(name="user_last_name")
	private String lastName;
	
	@Column(name="user_email", nullable=false, unique=true)
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_role_id", nullable=false)
	private UserRoles userrole;
	
	
	@OneToMany(mappedBy="ersAuthor", fetch=FetchType.EAGER)
	@JsonBackReference(value="ersAuthor")
	private List<Reimbursement> submittedReimbursements;

	
	@OneToMany(mappedBy="ersResolver", fetch=FetchType.EAGER)
	@JsonBackReference(value="ersResolver")
	private List<Reimbursement> resolvedReimbursements;
	
	
	public ERSUser(int userId, String username, String password, String firstName, String lastName, String email,
			UserRoles userrole) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userrole = userrole;
		
	}

	public ERSUser(String username, String password, String firstName, String lastName, String email,
			UserRoles userrole, List<Reimbursement> submittedReimbursements, List<Reimbursement> resolvedReimbursements) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userrole = userrole;
		this.submittedReimbursements = submittedReimbursements;		
		this.resolvedReimbursements = resolvedReimbursements;
	}
	

	public ERSUser() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoles getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRoles userrole) {
		this.userrole = userrole;
	}

	public List<Reimbursement> getSubmittedReimbursements() {
		return submittedReimbursements;
	}

	public void setSubmittedReimbursements(List<Reimbursement> submittedReimbursements) {
		this.submittedReimbursements = submittedReimbursements;
	}

	public List<Reimbursement> getResolvedReimbursements() {
		return resolvedReimbursements;
	}

	public void setResolvedReimbursements(List<Reimbursement> resolvedReimbursements) {
		this.resolvedReimbursements = resolvedReimbursements;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resolvedReimbursements == null) ? 0 : resolvedReimbursements.hashCode());
		result = prime * result + ((submittedReimbursements == null) ? 0 : submittedReimbursements.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userrole == null) ? 0 : userrole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERSUser other = (ERSUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resolvedReimbursements == null) {
			if (other.resolvedReimbursements != null)
				return false;
		} else if (!resolvedReimbursements.equals(other.resolvedReimbursements))
			return false;
		if (submittedReimbursements == null) {
			if (other.submittedReimbursements != null)
				return false;
		} else if (!submittedReimbursements.equals(other.submittedReimbursements))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userrole == null) {
			if (other.userrole != null)
				return false;
		} else if (!userrole.equals(other.userrole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERSUser [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userrole=" + userrole.getRoleName() + "]";
	}
	
	
	
	
	
	
}
