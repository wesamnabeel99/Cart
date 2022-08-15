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
        val parsedResponse = jsonParser.parseResponse(jsonString, isEven::class.java)

        assertEquals(isEven("if this test passed, you must drink water", true), parsedResponse)
    }
}

data class isEven(
    val ad: String?,
    val iseven: Boolean?,
)