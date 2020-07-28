package racingcar

import java.util.Random

class RacingCar(private val carCount: Int, private val playCount: Int) {

    val carList = arrayListOf<CarInformation>()

    init {
        for (carName in 1..carCount) {
            carList.add(CarInformation(carName = carName.toString()))
        }

        for (numberOfTimes in 1..playCount) {
            carList.forEach { it.randomMoving() }
        }
    }

    inner class CarInformation(val carName: String, var carDistance: String = "") {
        var randomMovingCount = 0
        fun randomMoving() {
            randomMovingCount++
            if (Random().nextInt(10) > 4) {
                carDistance += "-"
            }
        }
    }
}
