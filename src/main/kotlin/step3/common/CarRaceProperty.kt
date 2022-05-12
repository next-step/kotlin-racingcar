package step3.common

import step3.car.Car

class CarRaceProperty {
    val car = mutableMapOf<Int, Car>()
    var roundSize: Int = 0
    var carSize: Int = 0

    companion object {
        const val ROUND_START = 1
    }
}
