package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.racing.Winner

object RacingResultWriter {

    fun writeWinner(winners: List<Winner>) {
        print("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    fun writeBlank() = println()
}
