package printer

import racingcar.Position
import racingcar.Reception
import racingcar.Round
import racingcar.Rounds
import racingcar.Winners

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printWinners(winners: Winners) {
        print(winners.joinToWinners(Reception.CAR_NAME_DELIMITERS) + "가 최종 우승했습니다")
    }

    fun printRacing(rounds: Rounds) {
        rounds.forEach {
            printCarsPath(it)
            println()
        }
    }

    private fun printCarsPath(round: Round) {
        round.forEach {
            printName(it.name)
            printCarPath(it.position)
        }
    }

    private fun printCarPath(position: Position) {
        println("-".repeat(position.position))
    }

    private fun printName(name: String) {
        print("$name : ")
    }
}
