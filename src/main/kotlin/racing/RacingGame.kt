package racing

import racing.domain.Cars
import racing.domain.Movable
import racing.domain.RandomMove

class RacingGame(
    private val numberOfCars: Int = 2,
    private var countOfTry: Int = 1,
    private val movable: Movable = RandomMove()
) {

    private val cars: Cars = Cars.create(numberOfCars)

    fun race() = run {
        cars.move(movable)
        countOfTry--
    }

    fun isRacing() = countOfTry > 0

    fun positions() = cars.positions()
}
