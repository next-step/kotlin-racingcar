package racingcar.ui

import racingcar.domain.RacingGame

class ResultView {

    fun printRacingGameHistory(racingGame: RacingGame) {
        buildString {
            appendLine("실행 결과")
            racingGame.history.forEach { cars ->
                cars.forEach { car ->
                    append("${car.name} : ")
                    repeat(car.position) {
                        append('-')
                    }
                    appendLine()
                }
                appendLine()
            }
            val resultStr = buildString {
                racingGame.winners?.forEachIndexed { index, car ->
                    if (index > 0) {
                        append(", ")
                    }
                    append(car.name)
                }
                append("가 최종 우승했습니다.")
            }
            appendLine(resultStr)
        }.also {
            println(it)
        }
    }
}
