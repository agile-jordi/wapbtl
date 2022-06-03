package com.agilogy.wapbtl

val Arb.Companion.int get() = object: Arb<Int>{
    override fun generate(): Int = kotlin.random.Random.nextInt()
}