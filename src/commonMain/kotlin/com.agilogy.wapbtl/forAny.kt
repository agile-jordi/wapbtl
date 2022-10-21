package com.agilogy.wapbtl

import kotlin.random.Random

class PropertyFailedException(
    val attempt: Int,
    val seed: Long,
    val sample: Any?,
    override val cause: Throwable? = null
) : Exception(
    """Property failed at attempt $attempt
        |Sample $sample
        |Seed: $seed
        |Cause: ${cause?.message}""".trimMargin()
)

fun <A> forAny(r: Arb<A>, seed: Long? = null, property: (A) -> Boolean) {
    fun test(currentSeed: Long, attemptNumber: Int) {
        val sample = r.generate(Random(currentSeed))
        runCatching { property(sample) }.fold(
            onSuccess = { result ->
                if (!result) throw PropertyFailedException(attemptNumber, currentSeed, sample)
            },
            onFailure = { exception ->
                throw PropertyFailedException(attemptNumber, currentSeed, sample, exception)
            }
        )
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


fun <A> testForAny(aa: Arb<A>, seed: Long? = null, property: (A) -> Unit) =
    forAny(aa, seed) { a ->
        property(a)
        true
    }

fun <A, B> testForAny(aa: Arb<A>, ab: Arb<B>, seed: Long? = null, property: (A, B) -> Unit) =
    forAny(aa, ab, seed) { a, b ->
        property(a, b)
        true
    }

fun <A, B, C> testForAny(aa: Arb<A>, ab: Arb<B>, ac: Arb<C>, seed: Long? = null, property: (A, B, C) -> Unit) =
    forAny(aa, ab, ac, seed) { a, b, c ->
        property(a, b, c)
        true
    }