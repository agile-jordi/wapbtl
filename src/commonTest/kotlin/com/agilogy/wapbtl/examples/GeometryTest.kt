package com.agilogy.wapbtl.examples

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.forAny
import com.agilogy.wapbtl.int
import com.agilogy.wapbtl.map
import com.agilogy.wapbtl.product2
import kotlin.test.Test

data class Natural(val value: Int) {
    operator fun compareTo(other: Natural): Int = value.compareTo(other.value)
}

data class Coordinates(val x: Int, val y: Int)
data class Circle(val center: Coordinates, val radius: Natural) {
    val area: Double = kotlin.math.PI * radius.value * radius.value
}

class GeometryTest {

    private val distanceArb = Arb.int(0..10).map { Natural(it) }
    private val coordinateArb = Arb.int(-10..10)
    private val coordinatesArb = Arb.product2(coordinateArb, coordinateArb) { x, y -> Coordinates(x, y) }
    val circleArb = Arb.product2(coordinatesArb, distanceArb) { coords, radius -> Circle(coords, radius) }

    @Test
    fun testCircle() {
        forAny(circleArb, circleArb) { a, b -> (a.radius <= b.radius) == (a.area <= b.area) }
    }

}