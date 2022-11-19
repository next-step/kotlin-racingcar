package racingcar

import java.util.Collections

class RacingGame {
    var carList: List<Car> = listOf()
        private set

    fun set(numberOfCars: Int) {
        carList = Collections.nCopies(numberOfCars, Car())
    }
}
