package com.agilogy.wapbtl

fun <A, B> Arb.Companion.pair(a: Arb<A>, b: Arb<B>): Arb<Pair<A, B>> =
    product2(a, b, ::Pair)

fun <A, B, C> Arb.Companion.triple(a: Arb<A>, b: Arb<B>, c: Arb<C>): Arb<Triple<A, B, C>> =
    product3(a, b, c, ::Triple)

fun <A, B, Z> Arb.Companion.product2(
    a: Arb<A>, b: Arb<B>, f: (A, B) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(): Z = f(a.generate(), b.generate())
    }

fun <A, B, C, Z> Arb.Companion.product3(
    a: Arb<A>, b: Arb<B>, c: Arb<C>, f: (A, B, C) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(): Z = f(a.generate(), b.generate(), c.generate())
    }

fun <A, B, C, D, Z> Arb.Companion.product4(
    a: Arb<A>, b: Arb<B>, c: Arb<C>, d: Arb<D>, f: (A, B, C, D) -> Z
): Arb<Z> =
    object : Arb<Z> {
        override fun generate(): Z = f(a.generate(), b.generate(), c.generate(), d.generate())
    }