package racingcar

import java.util.Random

class Game(racingCars: RacingCars) {
    private val carList: List<RacingCar> = racingCars.carList

    fun playGameOnce(): List<RacingCar> = carList.onEach {
        it.move(Random().nextInt(10))
    }

    fun winner(): List<RacingCar> {
        return carList.filter { it.carDistance == findMaxDistance() }
    }

    private fun findMaxDistance(): Int {
        return carList.maxBy { it.carDistance }!!.carDistance
    }
}
