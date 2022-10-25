package com.agilogy.wapbtl

fun <A, B> Arb<A>.map(f: (A) -> B): Arb<B> =
    Arb { random -> f(this@map.generate(random)) }