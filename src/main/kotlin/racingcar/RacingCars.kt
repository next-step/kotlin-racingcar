package racingcar

import java.util.Random

class RacingCars {
    val carList: List<RacingCar>

    constructor(carNameList: List<String>) {
        carList = carNameList.map { RacingCar(it) }
    }

    fun playGameOnce(): List<RacingCar> = carList.onEach {
        it.move(Random().nextInt(10))
    }

    fun getWinner(): List<RacingCar> {
        return carList.filter { it.carDistance == findMaxDistance() }
    }

    private fun findMaxDistance(): Int {
        return carList.maxBy { it.carDistance }!!.carDistance
    }
}
