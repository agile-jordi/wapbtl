package com.agilogy.wapbtl

class PropertyFailedException(val attempt: Int, val sample: Any?) : Exception(
    "Property failed at attempt $attempt with sample $sample"
)

fun <A> forAny(r: Arb<A>, property: (A) -> Boolean) {
    (1..100).forEach { attemptNumber ->
        val sample = r.generate()
        val result = property(sample)
        if (!result)
            throw PropertyFailedException(attemptNumber, sample)
    }
}

fun <A, B> forAny(a: Arb<A>, b: Arb<B>, property: (A, B) -> Boolean) =
    forAny(Arb.pair(a, b)){ (a, b) -> property(a,b) }

fun <A, B, C> forAny(a: Arb<A>, b: Arb<B>, c: Arb<C>, property: (A, B, C) -> Boolean) =
    forAny(Arb.triple(a, b, c)){ (a, b, c) -> property(a,b, c) }