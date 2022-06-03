package com.agilogy.wapbtl

val Arb.Companion.boolean: Arb<Boolean> get() = object: Arb<Boolean>{
    override fun generate(): Boolean = kotlin.random.Random.nextBoolean()
}