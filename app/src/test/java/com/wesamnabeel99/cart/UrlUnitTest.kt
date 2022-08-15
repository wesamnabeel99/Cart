package com.wesamnabeel99.cart

import com.wesamnabeel99.cart.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class UrlUnitTest {

    @Test
    fun scheme_isCorrect() {
        assertEquals(Constants.SCHEME,"https")
    }

    @Test
    fun host_isCorrect() {
        assertEquals(Constants.HOST, "api.escuelajs.co")
    }

    @Test
    fun segment_isCorrect() {
        assertEquals(Constants.API_PATH_SEGMENT,"api/v1/")
    }
}