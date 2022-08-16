package com.wesamnabeel99.cart

import com.wesamnabeel99.cart.model.network.client.JsonParser
import org.junit.Assert.assertEquals
import org.junit.Test

class ParsingUnitTest {
    @Test
    fun parsing_isCorrect() {
        val jsonString =
            "{\"ad\": \"if this test passed, you must drink water\",\"iseven\": true\n}"
        val jsonParser = JsonParser()
        val parsedResponse = jsonParser.parseResponse(jsonString, IsEven::class.java)

        assertEquals(IsEven("if this test passed, you must drink water", true), parsedResponse)
    }
}

data class IsEven(
    val ad: String?,
    val iseven: Boolean?,
)