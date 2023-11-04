package racinggame.view

import racinggame.domain.Car
import racinggame.domain.RacingGameResult

object OutputView {

    fun printRacingResult(racingGameResult: RacingGameResult) {
        val result = buildString {
            append("실행 결과\n")
            racingGameResult.racingResult.map { round ->
                appendCarResult(round.result, this)
                append("\n")
            }
            racingGameResult.winners.joinToString(", ") { car ->
                car.name
            }.let {
                append("$it 가 최종 우승했습니다.")
            }
        }
        println(result)
    }

    private fun appendCarResult(round: List<Car>, sb: StringBuilder) {
        round.map { car ->
            (0..car.position).map {
                "-"
            }.reduce { s1, s2 ->
                s1 + s2
            }.let {
                sb.append("${car.name} : $it\n")
            }
        }
    }
}
