package step3.view

import step3.domain.RacingAttempt
import step3.domain.RacingRecord

class ResultView {
    fun outputRacingResult(racingRecord: RacingRecord) {
        racingRecord.attempts.forEach { attempt ->
            printAttempt(attempt)
        }
        printWinner(racingRecord)
    }

    private fun printAttempt(attempt: RacingAttempt) {
        println("####")
        attempt.carStates.forEach { carState ->
            println("${carState.name} : ${"-".repeat(carState.position)}")
        }
    }

    private fun printWinner(racingRecord: RacingRecord) {
        val winnerText = racingRecord.getWinners().joinToString()
        println("$winnerText 가 최종 우승했습니다.")
    }
}
