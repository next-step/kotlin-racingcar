package racingcar

import racingcar.domain.Car
import racingcar.utils.RandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    fun play() {
        val carNames = InputView.carNamesInput()
        val tryCount = InputView.displayInput("시도할 회수는 몇 회 인가요?")
        val cars = carNames.map { Car(it) }
        val randomGenerator = RandomGenerator(0, 9)

        ResultView.displayRacingStartMessage()
        repeat(tryCount) {
            cars.map {
                it.move((randomGenerator.generate()))
                ResultView.displayCarLocation(it)
            }
            println()
        }
        ResultView.displayWinner(cars)
    }
}
