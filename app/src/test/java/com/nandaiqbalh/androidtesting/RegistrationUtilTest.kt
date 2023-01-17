package com.nandaiqbalh.androidtesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

	@Test
	fun `empty username returns false`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"",
			"123",
			"123"
		)

		assertThat(result).isFalse()
	}

	@Test
	fun `valid username and correctly repeated password returns true`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"nandaiqbalh",
			"123",
			"123"
		)

		assertThat(result).isTrue()
	}

	@Test
	fun `username already exist returns false`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"David",
			"123",
			"123"
		)

		assertThat(result).isFalse()
	}

	@Test
	fun `empty password returns false`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"nandaiqbalh",
			"",
			"123"
		)

		assertThat(result).isFalse()
	}

	@Test
	fun `password was repeated incorrectly returns false`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"nandaiqbalh",
			"123",
			"abcdef"
		)

		assertThat(result).isFalse()
	}

	@Test
	fun `password contains less than 2 digits returns false`() {
		val result = RegistrationUtil.validateRegistrationInput(
			"David",
			"1",
			"1"
		)

		assertThat(result).isFalse()
	}
}