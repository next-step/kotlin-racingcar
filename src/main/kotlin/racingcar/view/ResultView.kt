package racingcar.view

import racingcar.domain.car.CarName
import racingcar.domain.car.CarRacingResult

class ResultView {

    fun show(result: List<CarRacingResult>, winners: Set<CarName>) {
        val resultString = buildString {
            append(makeProgressString(result))
            append("${winners}가 최종 우승했습니다.")
        }

        println(resultString)
    }

    private fun makeProgressString(result: List<CarRacingResult>): StringBuilder {
        val progress = StringBuilder()

        result.forEach { moves ->
            moves.forEach { (name, distance) ->
                progress.append("$name : ${"".padEnd(distance, '-')}\n")
            }
            progress.append("\n")
        }

        return progress
    }
}
