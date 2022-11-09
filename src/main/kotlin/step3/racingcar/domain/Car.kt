package step3.racingcar.domain

import java.util.UUID

class Car {
    private val id: String = UUID.randomUUID().toString()
    private var roundResults: RoundResults = RoundResults()

    fun race(round: Int, randomNumber: Int): RoundResult =
        RoundResult(round, MoveStatus.match(randomNumber)).apply {
            roundResults.accumulate(this)
        }

    fun accumulatedScore(): Int = roundResults.addUpAccelerateCount()

    fun roundCount(): Int = roundResults.size()
}
