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

    @Test
    fun forAny2ArbsFailure() {
        val property: (Int, Int) -> Boolean = { a, b -> (a + b) > a }
        var attempts = 0
        val failure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int, Arb.int) { a, b ->
                attempts += 1
                property(a, b)
            }
        }
        @Suppress("UNCHECKED_CAST")
        val failedSample = failure.sample as Pair<Int, Int>
        assertFalse { property(failedSample.first, failedSample.second) }
        assertEquals(attempts, failure.attempt)
    }

    @Test
    fun forAny3ArbsFailure() {
        val property: (Int, Int, Int) -> Boolean = { a, b, c -> (a + b + c) > a }
        var attempts = 0
        val failure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int, Arb.int, Arb.int) { a, b, c ->
                attempts += 1
                property(a, b, c)
            }
        }
        @Suppress("UNCHECKED_CAST")
        val failedSample = failure.sample as Triple<Int, Int, Int>
        assertFalse { property(failedSample.first, failedSample.second, failedSample.third) }
        assertEquals(attempts, failure.attempt)
    }

}