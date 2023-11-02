package racinggame.view

import racinggame.domain.Car
import racinggame.domain.RoundResult

object OutputView {

    fun printRacingResult(racingResult: List<RoundResult>) {
        println("실행 결과")
        racingResult.map { round ->
            round.result.map { car ->
                (0..car.position).map {
                    "-"
                }.reduce { s1, s2 ->
                    s1 + s2
                }.let {
                    println("${car.name} : $it")
                }
            }
            println()
        }
    }

    fun printWinners(winners: List<Car>) =
        winners.joinToString(", ") { car ->
            car.name
        }.let {
            println("$it 가 최종 우승했습니다.")
        }
}
