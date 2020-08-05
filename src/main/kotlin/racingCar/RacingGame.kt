package racingCar

import kotlin.random.Random

object RacingGame {
    private const val MIN_NUMBER = 0
    private const val MAX_NUMBER = 10

    fun playGame(numberOfRound: Int, cars: Cars) {
        for (round in 0 until numberOfRound) {
            for (car in cars.cars) {
                car.move(getRandomNumbers())
            }
        }
    }

    private fun getRandomNumbers(): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    }
}
