package study.racingcar.step3

import kotlin.random.Random

class RacingRun(private val racingCars: List<Racing>) {

    fun nextRun() {
        for (racingCar in racingCars) racingCar.run(Random.nextInt(0, 9))
    }
}
