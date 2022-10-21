package com.agilogy.wapbtl

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong
import kotlin.random.nextUInt
import kotlin.random.nextULong

val Arb.Companion.int: Arb<Int>
    get() = object : Arb<Int> {
        override fun generate(random: Random): Int = random.nextInt()
    }

fun Arb.Companion.int(range: IntRange): Arb<Int> = object : Arb<Int> {
    override fun generate(random: Random): Int = random.nextInt(range)
}

val Arb.Companion.uint: Arb<UInt>
    get() = object : Arb<UInt> {
        override fun generate(random: Random): UInt = random.nextUInt()
    }

fun Arb.Companion.uint(range: UIntRange): Arb<UInt> = object : Arb<UInt> {
    override fun generate(random: Random): UInt = random.nextUInt(range)
}

val Arb.Companion.long: Arb<Long>
    get() = object : Arb<Long> {
        override fun generate(random: Random): Long = random.nextLong()
    }

fun Arb.Companion.long(range: LongRange): Arb<Long> = object : Arb<Long> {
    override fun generate(random: Random): Long = random.nextLong(range)
}

val Arb.Companion.ulong: Arb<ULong>
    get() = object : Arb<ULong> {
        override fun generate(random: Random): ULong = random.nextULong()
    }

fun Arb.Companion.ulong(range: ULongRange): Arb<ULong> = object : Arb<ULong> {
    override fun generate(random: Random): ULong = random.nextULong(range)
}