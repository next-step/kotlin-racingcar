package racing

import racing.domain.Cars
import racing.domain.Movable
import racing.domain.RandomMove

private const val FINISHED_COUNT_OF_TRY = 0

class RacingGame(
    private val cars: Cars,
    private var countOfTry: Int = 1,
    private val movable: Movable = RandomMove()
) {

    fun race() {
        cars.move(movable)
        countOfTry--
    }

    fun isPlaying() = countOfTry > FINISHED_COUNT_OF_TRY

    fun cars() = cars
}
