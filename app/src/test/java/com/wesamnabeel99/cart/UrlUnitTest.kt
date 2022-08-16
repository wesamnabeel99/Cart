package com.wesamnabeel99.cart

import com.wesamnabeel99.cart.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class UrlUnitTest {

    @Test
    fun scheme_isCorrect() {
        assertEquals("https", Constants.SCHEME)
    }

    @Test
    fun host_isCorrect() {
        assertEquals("api.escuelajs.co", Constants.HOST)
    }

    @Test
    fun segment_isCorrect() {
        assertEquals("api/v1/", Constants.API_PATH_SEGMENT)
    }
}