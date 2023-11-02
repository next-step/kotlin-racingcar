package racinggame.view

import racinggame.domain.PlayWinners
import racinggame.domain.RacingGameResult

object OutputView {

    fun printRacingResult(racingResult: RacingGameResult) {
        println("실행 결과")
        racingResult.translate().forEach { result ->
            result.forEach {
                println(it)
            }
            println()
        }
    }

    fun printWinners(winners: PlayWinners) {
        println("${winners.translate()} 가 최종 우승했습니다.")
    }
}
