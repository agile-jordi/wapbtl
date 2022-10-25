package com.agilogy.wapbtl

import kotlin.random.Random

fun interface Arb<A> {
    fun generate(random: Random): A

    companion object
}