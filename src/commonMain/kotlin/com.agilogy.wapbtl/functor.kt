package com.agilogy.wapbtl

fun <A, B> Arb<A>.map(f: (A) -> B): Arb<B> = object: Arb<B>{
    override fun generate(): B = f(this@map.generate())
}