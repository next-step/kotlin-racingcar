package racingcar.domain

import kotlin.random.Random

class RacingGame(
    val carSize: Int,
    val attemptSize: Int
) {
    private val cars = List(carSize) { Car() }
    private var curAttemptNum: Int = 0

    fun attempt() {
        check(curAttemptNum < attemptSize)

        cars.forEach {
            it.move(Random.nextInt(10))
        }
        curAttemptNum++
    }

    fun getCarPositions(): List<Int> = cars.map { it.position }
}
