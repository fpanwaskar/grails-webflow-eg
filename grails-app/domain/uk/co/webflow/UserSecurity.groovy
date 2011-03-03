package uk.co.webflow

class UserSecurity {

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<UserRole> getAuthorities() {
		UserSecurityUserRole.findAllByUserSecurity(this).collect { it.userRole } as Set
	}
}
