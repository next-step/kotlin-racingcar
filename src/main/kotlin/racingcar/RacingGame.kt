package racingcar

import racingcar.domain.Car
import racingcar.utils.RandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    fun play() {
        val carCount = InputView.displayInput("자동차 대수는 몇 대 인가요?")
        val tryCount = InputView.displayInput("시도할 회수는 몇 회 인가요?")
        val cars = List(carCount) { Car() }
        val randomGenerator = RandomGenerator(0, 9)

        ResultView.displayRacingStartMessage()
        repeat(tryCount) {
            cars.map {
                ResultView.displayCarLocation(it.move((randomGenerator.generate())))
            }
            println()
        }
    }
}
