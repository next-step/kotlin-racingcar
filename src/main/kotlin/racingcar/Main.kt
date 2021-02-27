package racingcar

import racingcar.model.RacingCarGame
import racingcar.strategy.CarMoveMoveStrategy
import racingcar.utils.InputUtils

fun main() {
    val inputDto = InputUtils.askQuestions()

    val racingCarGame = RacingCarGame.ready(inputDto.carCount)

    val moveStrategy = CarMoveMoveStrategy()
    for (i in 1..inputDto.gameCount) {
        val resultViews = racingCarGame.moveOnce(moveStrategy)
        resultViews.printResults()
    }
}
