package racingcar.resultviews

import racingcar.dtos.GameResult

interface ResultView {
    fun printResult(gameResult: GameResult)
}
