package com.agilogy.wapbtl

import kotlin.random.Random

class PropertyFailedException(val attempt: Int, val seed: Long, val sample: Any?) : Exception(
    "Property failed at attempt $attempt with sample $sample.\nSeed: $seed"
)

fun <A> forAny(r: Arb<A>, seed: Long? = null, property: (A) -> Boolean) {
    fun test(currentSeed: Long, attemptNumber: Int) {
        val sample = r.generate(Random(currentSeed))
        val result = property(sample)
        if (!result)
            throw PropertyFailedException(attemptNumber, currentSeed, sample)
    }
    if (seed == null) {
        (1..100).forEach { attemptNumber ->
            test(Random.Default.nextLong(), attemptNumber)
        }
    } else {
        test(seed, 1)
    }

}

fun <A, B> forAny(a: Arb<A>, b: Arb<B>, seed: Long? = null, property: (A, B) -> Boolean): Unit =
    forAny(Arb.pair(a, b), seed) { (a, b) -> property(a, b) }

fun <A, B, C> forAny(a: Arb<A>, b: Arb<B>, c: Arb<C>, seed: Long? = null, property: (A, B, C) -> Boolean) =
    forAny(Arb.triple(a, b, c), seed) { (a, b, c) -> property(a, b, c) }