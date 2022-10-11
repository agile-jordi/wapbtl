package com.agilogy.wapbtl.examples.geometry.test

import com.agilogy.wapbtl.Arb
import com.agilogy.wapbtl.examples.geometry.main.Circle
import com.agilogy.wapbtl.examples.geometry.main.Coordinates
import com.agilogy.wapbtl.examples.geometry.main.Natural
import com.agilogy.wapbtl.int
import com.agilogy.wapbtl.map
import com.agilogy.wapbtl.product2

class GeometryTest {

    val distanceArb = Arb.int(0..10).map { Natural(it) }
    val coordinateArb = Arb.int(-10..10)
    val coordinatesArb = Arb.product2(coordinateArb, coordinateArb) { x, y -> Coordinates(x, y) }
    val circleArb = Arb.product2(coordinatesArb, distanceArb) { coords, radius -> Circle(coords, radius) }

}