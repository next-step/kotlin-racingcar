package racing_car

import racing_car.domain.RacingGame
import racing_car.view.InputView
import racing_car.view.ResultView

fun main() {

    val racingGame = RacingGame(
        numberOfCars = InputView.inputNumberOfCars(),
        racingRound = InputView.inputRacingRound()
    )

    // 실행 결과
    ResultView.printResultTitle()
    while (racingGame.isContinuable) {
        racingGame.move()
        ResultView.printPosition(racingGame.cars)
    }
}
