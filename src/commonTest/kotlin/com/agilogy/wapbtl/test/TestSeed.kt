package com.agilogy.wapbtl.test

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.PropertyFailedException
import com.agilogy.wapbtl.forAny
import com.agilogy.wapbtl.int
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestSeed {

    @Test
    fun forAnySeedParameterShouldReproduceTheFailingTest() {
        val property: (Int) -> Boolean = { i -> i + i >= i }
        val failure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int, property = property)
        }
        var actualExecutionsWithSeed = 0
        val seededFailure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int, failure.seed) {
                actualExecutionsWithSeed++
                property(it)
            }
        }
        assertEquals(failure.sample, seededFailure.sample)
        assertEquals(failure.seed, seededFailure.seed)
        assertEquals(1, seededFailure.attempt)
        assertEquals(1, actualExecutionsWithSeed)
    }
}
