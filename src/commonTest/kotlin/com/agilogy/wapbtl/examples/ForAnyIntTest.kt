package com.agilogy.wapbtl.examples

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.forAny
import com.agilogy.wapbtl.int
import com.agilogy.wapbtl.pair
import kotlin.test.Test

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

}