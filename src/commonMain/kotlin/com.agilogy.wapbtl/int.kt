package com.agilogy.wapbtl

import kotlin.random.nextInt
import kotlin.random.nextLong
import kotlin.random.nextUInt
import kotlin.random.nextULong

val Arb.Companion.int: Arb<Int>
    get() = Arb { random -> random.nextInt() }

fun Arb.Companion.int(range: IntRange): Arb<Int> =
    Arb { random -> random.nextInt(range) }

val Arb.Companion.uint: Arb<UInt>
    get() = Arb { random -> random.nextUInt() }

fun Arb.Companion.uint(range: UIntRange): Arb<UInt> =
    Arb { random -> random.nextUInt(range) }

val Arb.Companion.long: Arb<Long>
    get() = Arb { random -> random.nextLong() }

fun Arb.Companion.long(range: LongRange): Arb<Long> = Arb { random -> random.nextLong(range) }

val Arb.Companion.ulong: Arb<ULong>
    get() = Arb { random -> random.nextULong() }

fun Arb.Companion.ulong(range: ULongRange): Arb<ULong> = Arb { random -> random.nextULong(range) }