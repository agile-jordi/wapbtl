package com.agilogy.wapbtl

inline fun <reified E : Enum<E>> Arb.Companion.enum(): Arb<E> {
    val values = enumValues<E>()
    return Arb.int(values.indices).map { values[it] }
}