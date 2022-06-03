package com.agilogy.wapbtl

val Arb.Companion.float: Arb<Float> get() = object: Arb<Float>{
    override fun generate(): Float = kotlin.random.Random.nextFloat()
}

val Arb.Companion.double: Arb<Double> get() = object: Arb<Double>{
    override fun generate(): Double = kotlin.random.Random.nextDouble()
}
