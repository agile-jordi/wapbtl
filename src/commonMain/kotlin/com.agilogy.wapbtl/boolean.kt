package com.agilogy.wapbtl

val Arb.Companion.boolean: Arb<Boolean>
    get() = Arb { random -> random.nextBoolean() }