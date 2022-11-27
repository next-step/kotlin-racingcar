package racing

import racing.domain.Cars
import racing.domain.Movable
import racing.domain.RandomMove

private const val FINISHED_COUNT_OF_TRY = 0

class RacingGame(
    private val numberOfCars: Int = 2,
    private var countOfTry: Int = 1,
    private val movable: Movable = RandomMove()
) {

    private val cars: Cars = Cars.create(numberOfCars)

    fun race() = {
        cars.move(movable)
        countOfTry--
    }

    fun isRacing() = countOfTry > FINISHED_COUNT_OF_TRY

    fun positions() = cars.positions()
}
