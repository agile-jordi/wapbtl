package com.agilogy.wapbtl

import kotlin.test.Test

enum class DayOfWeek {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun;
}

fun Arb.Companion.dayOfWeek() =
    Arb.int(0..6).map { DayOfWeek.values()[it] }

class DayOfWeekTest {
    @Test
    fun testDayOfWeek() = forAny(Arb.dayOfWeek()) { it.name.length == 3 }
}