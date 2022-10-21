package com.agilogy.wapbtl

import kotlin.random.Random

val Arb.Companion.float: Arb<Float>
    get() = object : Arb<Float> {
        override fun generate(random: Random): Float = random.nextFloat()
    }

val Arb.Companion.double: Arb<Double>
    get() = object : Arb<Double> {
        override fun generate(random: Random): Double = random.nextDouble()
    }
