package uk.co.webflow

import org.apache.commons.lang.builder.HashCodeBuilder

class UserSecurityUserRole implements Serializable {

	UserSecurity userSecurity
	UserRole userRole

	boolean equals(other) {
		if (!(other instanceof UserSecurityUserRole)) {
			return false
		}

		other.userSecurity?.id == userSecurity?.id &&
			other.userRole?.id == userRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (userSecurity) builder.append(userSecurity.id)
		if (userRole) builder.append(userRole.id)
		builder.toHashCode()
	}

	static UserSecurityUserRole get(long userSecurityId, long userRoleId) {
		find 'from UserSecurityUserRole where userSecurity.id=:userSecurityId and userRole.id=:userRoleId',
			[userSecurityId: userSecurityId, userRoleId: userRoleId]
	}

	static UserSecurityUserRole create(UserSecurity userSecurity, UserRole userRole, boolean flush = false) {
		new UserSecurityUserRole(userSecurity: userSecurity, userRole: userRole).save(flush: flush, insert: true)
	}

	static boolean remove(UserSecurity userSecurity, UserRole userRole, boolean flush = false) {
		UserSecurityUserRole instance = UserSecurityUserRole.findByUserSecurityAndUserRole(userSecurity, userRole)
		instance ? instance.delete(flush: flush) : false
	}

	static void removeAll(UserSecurity userSecurity) {
		executeUpdate 'DELETE FROM UserSecurityUserRole WHERE userSecurity=:userSecurity', [userSecurity: userSecurity]
	}

	static void removeAll(UserRole userRole) {
		executeUpdate 'DELETE FROM UserSecurityUserRole WHERE userRole=:userRole', [userRole: userRole]
	}

	static mapping = {
		id composite: ['userRole', 'userSecurity']
		version false
	}
}
