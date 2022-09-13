package com.agilogy.wapbtl

import kotlin.random.Random

fun <A, B> Arb.Companion.pair(a: Arb<A>, b: Arb<B>): Arb<Pair<A, B>> =
    product2(a, b, ::Pair)

fun <A, B, C> Arb.Companion.triple(a: Arb<A>, b: Arb<B>, c: Arb<C>): Arb<Triple<A, B, C>> =
    product3(a, b, c, ::Triple)

fun <A, B, Z> Arb.Companion.product2(
    a: Arb<A>, b: Arb<B>, f: (A, B) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(random: Random): Z = f(a.generate(random), b.generate(random))
    }

fun <A, B, C, Z> Arb.Companion.product3(
    a: Arb<A>, b: Arb<B>, c: Arb<C>, f: (A, B, C) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(random: Random): Z = f(a.generate(random), b.generate(random), c.generate(random))
    }

fun <A, B, C, D, Z> Arb.Companion.product4(
    a: Arb<A>, b: Arb<B>, c: Arb<C>, d: Arb<D>, f: (A, B, C, D) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(random: Random): Z =
            f(a.generate(random), b.generate(random), c.generate(random), d.generate(random))
    }