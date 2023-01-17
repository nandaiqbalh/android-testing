package com.nandaiqbalh.androidtesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest{

	/**
	 * This is not the best practice because, sometimes test case start with the different conditions
	 * and it will make the result of the test is SOMETIMES TRUE SOMETIMES FALSE
	 */
//	private val resourceComparer = ResourceComparer()

	private lateinit var resourceComparer: ResourceComparer

	@Before
	fun setup(){
		resourceComparer = ResourceComparer()
	}

	@After
	fun teardown(){

	}

	@Test
	fun stringResourceSameAsGivenString_returnsTrue(){

		val context = ApplicationProvider.getApplicationContext<Context>()

		val result = resourceComparer.isEqual(context, R.string.app_name, "AndroidTesting")

		assertThat(result).isTrue()
	}

	@Test
	fun stringResourceDifferentAsGivenString_returnsFalse(){

		val context = ApplicationProvider.getApplicationContext<Context>()

		val result = resourceComparer.isEqual(context, R.string.app_name, "DifferentString")

		assertThat(result).isFalse()
	}

}