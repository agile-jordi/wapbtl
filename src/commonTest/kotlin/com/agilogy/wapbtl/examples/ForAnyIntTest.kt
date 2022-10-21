package com.agilogy.wapbtl.examples

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.forAny
import com.agilogy.wapbtl.int
import com.agilogy.wapbtl.pair
import com.agilogy.wapbtl.testForAny
import kotlin.test.Test
import kotlin.test.assertEquals

class ForAnyIntTest {

    @Test
    fun testSum0() = forAny(Arb.int) { i -> i + 0 == i }

    @Test
    fun testSumCommutativity() {
        forAny(Arb.pair(Arb.int, Arb.int)) { (a, b) -> a + b == b + a }
        forAny(Arb.int, Arb.int) { a, b -> a + b == b + a }
    }

    @Test
    fun testAssociativity() {
        forAny(Arb.int, Arb.int, Arb.int) { a, b, c -> (a + b) + c == a + (b + c) }
    }

    @Test
    fun testIntegerDivision() {
        forAny(Arb.int, Arb.int) { a, b ->
            b == 0 || a == b * (a / b) + a % b
        }
    }

    @Test
    fun testIntegerDivision2() {
        testForAny(Arb.int, Arb.int) { a, b ->
            if (b != 0) {
                assertEquals(a, b * (a / b) + a % b)
            }
        }
    }

}