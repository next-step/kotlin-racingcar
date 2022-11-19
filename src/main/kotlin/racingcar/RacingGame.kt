package racingcar

import java.util.Collections
import kotlin.random.Random

class RacingGame {
    var carList: List<Car> = listOf()
        private set

    fun set(numberOfCars: Int) {
        carList = Collections.nCopies(numberOfCars, Car())
    }

    private fun random(): Int {
        return Random.nextInt(MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val MAX_RANDOM_NUMBER: Int = 9
    }
}
