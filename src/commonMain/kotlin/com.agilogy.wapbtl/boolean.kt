package com.agilogy.wapbtl

import kotlin.random.Random

val Arb.Companion.boolean: Arb<Boolean> get() = object: Arb<Boolean>{
    override fun generate(random: Random): Boolean = random.nextBoolean()
}