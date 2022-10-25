package com.agilogy.wapbtl

fun <A : Any> Arb<A>.orNull(nullProbability: Double): Arb<A?> =
    Arb { random ->
        if (random.nextDouble(0.0, 1.0) <= nullProbability) null
        else this@orNull.generate(random)
    }