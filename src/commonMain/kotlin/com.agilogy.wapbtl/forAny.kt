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