package step3.racingcar.domain

import java.util.UUID

const val CAR_ID_DELIMITER = "-"

class Car {
    val id: String = UUID.randomUUID().toString().substringBefore(CAR_ID_DELIMITER)
    var roundResults: RoundResults = RoundResults()

    fun race(round: Int, randomNumber: Int): RoundResult =
        RoundResult(round, MoveStatus.match(randomNumber)).apply {
            roundResults.accumulate(this)
        }

    fun acceleratedRoundCount(): Int = roundResults.acceleratedCount()

    fun playRoundCount(): Int = roundResults.size()
}
