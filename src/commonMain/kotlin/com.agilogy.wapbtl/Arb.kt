package com.agilogy.wapbtl

import kotlin.random.Random

interface Arb<A> {
    fun generate(random: Random): A
    companion object
}