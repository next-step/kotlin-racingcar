package racingcar.views.resultviews

import racingcar.domain.dtos.GameResult

interface ResultView {
    fun printResult(gameResult: GameResult)
}
