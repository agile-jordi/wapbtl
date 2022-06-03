package com.agilogy.wapbtl

interface Arb<A> {
    fun generate(): A
    companion object
}