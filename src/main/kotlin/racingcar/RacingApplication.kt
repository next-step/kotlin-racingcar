package racingcar

import racingcar.application.RacingService
import racingcar.infra.DefaultMoveStrategy
import racingcar.ui.RacingController

fun main() {

    InputView.displayCarNames()
    val carNames: String = readln()
    require(carNames.isNotBlank()) { "잘못된 요청 입니다." }

    InputView.displayRoundCount()
    val roundCount: String = readln()
    require(roundCount.isNotBlank()) { "잘못된 요청 입니다." }

    val racingController = RacingController(RacingService(DefaultMoveStrategy()))
    val racingResponse = racingController.play(carNames, roundCount)
    OutputView.display(racingResponse.allResult)

    val final = racingResponse.allResult
        .last()
        .cars

    val winnerResponse = racingController.winner(final)
    OutputView.winner(winnerResponse.winner.winners)
}
