package racingcar.controller

import racingcar.domain.GameInfo
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val gameInfo = GameInfo(
        carInfo = InputView.getCarInfo(),
        trialCount = InputView.getTrialCount()
    )

    val race = Race.create(names = gameInfo.carInfo.names)

    ResultView.printResultMessage()
    repeat(gameInfo.trialCount) { round ->
        val resultOfRound = race.proceedRound(cars = race.cars)
        ResultView.printTraceOfRound(
            round = round,
            cars = resultOfRound
        )
    }

    ResultView.printWinner(winner = race.getWinner())
}
