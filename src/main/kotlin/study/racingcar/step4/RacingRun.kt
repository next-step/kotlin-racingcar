package study.racingcar.step4

import kotlin.random.Random

class RacingRun(private val racingCars: List<Racing>) {

    private val fromValue: Int = 0
    private val toValue: Int = 9

    fun nextRun() {
        for (racingCar in racingCars) racingCar.run(randomRunValue())
    }

    fun racingCarStatusList(): List<RacingCarStatus> {
        return racingCars.map { racingCar -> RacingCarStatus(racingCar.name(), racingCar.position()) }
    }

    private fun randomRunValue(): Int {
        return Random.nextInt(fromValue, toValue)
    }
}
