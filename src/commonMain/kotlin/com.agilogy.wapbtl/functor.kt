package com.agilogy.wapbtl

import kotlin.random.Random

fun <A, B> Arb<A>.map(f: (A) -> B): Arb<B> = object: Arb<B>{
    override fun generate(random: Random): B = f(this@map.generate(random))
}