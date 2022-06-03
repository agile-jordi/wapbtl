package com.agilogy.wapbtl

import kotlin.random.nextInt
import kotlin.random.nextLong
import kotlin.random.nextUInt
import kotlin.random.nextULong

val Arb.Companion.int: Arb<Int> get() = object : Arb<Int> {
        override fun generate(): Int = kotlin.random.Random.nextInt()
}

fun Arb.Companion.int(range: IntRange): Arb<Int> = object : Arb<Int> {
    override fun generate(): Int = kotlin.random.Random.nextInt(range)
}

val Arb.Companion.uint: Arb<UInt> get() = object : Arb<UInt> {
        override fun generate(): UInt = kotlin.random.Random.nextUInt()
}

fun Arb.Companion.uint(range: UIntRange): Arb<UInt> = object : Arb<UInt> {
    override fun generate(): UInt = kotlin.random.Random.nextUInt(range)
}

val Arb.Companion.long: Arb<Long> get() = object : Arb<Long> {
    override fun generate(): Long = kotlin.random.Random.nextLong()
}

fun Arb.Companion.long(range: LongRange): Arb<Long> = object : Arb<Long> {
    override fun generate(): Long = kotlin.random.Random.nextLong(range)
}

val Arb.Companion.ulong: Arb<ULong> get() = object : Arb<ULong> {
    override fun generate(): ULong = kotlin.random.Random.nextULong()
}

fun Arb.Companion.ulong(range: ULongRange): Arb<ULong> = object : Arb<ULong> {
    override fun generate(): ULong = kotlin.random.Random.nextULong(range)
}