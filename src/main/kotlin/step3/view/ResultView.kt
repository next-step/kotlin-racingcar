package step3.view

import step3.domain.RacingRecord

class ResultView {
    fun outputRacingResult(racingRecord: RacingRecord) {
        racingRecord.attempts.forEach { attempt ->
            println("####")
            attempt.carStates.forEach { carState ->
                println("${carState.name} : ${"-".repeat(carState.position)}")
            }
        }
    }
}
