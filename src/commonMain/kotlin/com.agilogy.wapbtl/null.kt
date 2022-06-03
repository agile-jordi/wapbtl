package com.agilogy.wapbtl

import kotlin.random.Random

fun <A : Any> Arb<A>.orNull(nullProbability: Double): Arb<A?> = object : Arb<A?> {
    override fun generate(): A? =
        if (Random.nextDouble(0.0, 1.0) <= nullProbability) null
        else this@orNull.generate()
}