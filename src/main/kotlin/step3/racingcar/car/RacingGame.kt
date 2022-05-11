package step3.racingcar.car

import step3.racingcar.InputParser
import step3.racingcar.RandomNumberGenerator
import step3.racingcar.view.ResultView

class RacingGame private constructor(
    private val drivers: List<Driver>,
    private val trialCount: Int
) {

    // TODO: 2022/05/09 RacingGame에서 inputView의 역할을 같이 하고 있는것 같은.. 고민이 있는데 input을 어느시점에 분리하는게 좋을지 고민...
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
        fun init(): RacingGame {
            println("자동차 대수는 몇 대 인가요?")
            val numberOfCar = InputParser.toInt(readln())

            println("시도할 횟수는 몇 회 인가요?")
            val trialCount = InputParser.toInt(readln())

            val drivers = mutableListOf<Driver>()
            repeat(numberOfCar) {
                drivers.add(Driver(Car()))
            }

            return RacingGame(drivers, trialCount)
        }
    }
}
