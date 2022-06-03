package com.agilogy.wapbtl

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class ForAnyIntTest {

    @Test
    fun testSum0() = forAny(Arb.int) { i -> i + 0 == i }

    @Test
    fun testDoubleIsGreater() {
        val property: (Int) -> Boolean =  { i -> i + i >= i }
        val failure = assertFailsWith<PropertyFailedException> {
            forAny(Arb.int, property)
        }
        val failedSample = failure.sample as Int
        assertFalse { property(failedSample) }
    }

    @Test
    fun testSumCommutativity() {
        forAny(Arb.pair(Arb.int, Arb.int)){ (a, b) -> a + b == b + a }
        forAny(Arb.int, Arb.int){ a, b -> a + b == b + a }
    }
}