package com.agilogy.wapbtl.test

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.PropertyFailedException
import com.agilogy.wapbtl.forAny
import com.agilogy.wapbtl.int
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class ForAnyTest {

    @Test
    fun testForAnyFailure() {
        val property: (Int) -> Boolean = { i -> i + i >= i }
        var attempts = 0
        val failure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int) {
                attempts += 1
                property(it)
            }
        }
        val failedSample = failure.sample as Int
        assertFalse { property(failedSample) }
        assertEquals(attempts, failure.attempt)
    }
}