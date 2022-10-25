package com.agilogy.wapbtl

val Arb.Companion.float: Arb<Float>
    get() = Arb { random -> random.nextFloat() }

val Arb.Companion.double: Arb<Double>
    get() = Arb { random -> random.nextDouble() }
