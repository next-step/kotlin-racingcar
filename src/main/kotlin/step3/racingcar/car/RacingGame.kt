package step3.racingcar.car

import step3.racingcar.RandomNumberGenerator
import step3.racingcar.view.ResultView

class RacingGame private constructor(
    private val drivers: List<Driver>,
    private val trialCount: Int
) {

    fun play() {
        repeat(trialCount) {
            drivers.forEach {
                it.drive(RandomNumberGenerator.generate())
                ResultView.show(it.getMoveResult())
                println()
            }
            println()
        }
    }

    companion object {
        fun init(numberOfCar: Int, trialCount: Int): RacingGame {
            val drivers = List(numberOfCar) { Driver(Car()) }
            return RacingGame(drivers, trialCount)
        }
    }
}
