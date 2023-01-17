package com.nandaiqbalh.androidtesting

object RegistrationUtil {

	// fake database user
	private val existingUser = listOf("David", "Bruno", "Fernandes")

	/**
	 * the input is not valid if...
	 * ... the username/password is empty
	 * ... the username is already taken
	 * ... the confirmed password is not the same as real password
	 * ... the password is less than 2 digits
	 */

	fun validateRegistrationInput(
		username: String,
		password: String,
		confirmedPassword: String
	) : Boolean {

		if (username.isEmpty() || password.isEmpty()){
			return false
		}

		if (username in existingUser){
			return false
		}

		if (confirmedPassword != password){
			return false
		}

		if (password.count { it.isDigit() }< 2) {
			return false
		}

		return true
	}
}