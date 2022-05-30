package step4.racingcar.racingcar

import step4.racingcar.racingcar.domain.Car
import step4.racingcar.racingcar.domain.CarRacing
import step4.racingcar.racingcar.domain.RandomNumber
import step4.racingcar.racingcar.view.InputView
import step4.racingcar.racingcar.view.ResultView

fun main() {

    val racers = InputView.racers()
    val movementCount = InputView.movementCount()

    val racingGame = CarRacing(racers.map { Car(it) }, movementCount)
    racingGame.execute(RandomNumber)
    ResultView.view(racingGame)
}
