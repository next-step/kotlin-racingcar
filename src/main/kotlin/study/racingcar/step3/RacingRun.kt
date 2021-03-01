package study.racingcar.step3

import kotlin.random.Random

class RacingRun(private val racingCars: List<Racing>) {

    private val fromValue: Int = 0
    private val toValue: Int = 9

    fun nextRun() {
        for (racingCar in racingCars) racingCar.run(randomRunValue())
    }

    private fun randomRunValue(): Int {
        return Random.nextInt(fromValue, toValue)
    }
}
