package step3.racingcar.domain

import java.util.UUID

class Car {
    private val id: String = UUID.randomUUID().toString()
    private var moveStates: MoveStates = MoveStates()

    fun race(randomNumber: Int) = moveStates.progressRound(randomNumber)

    fun moveCount(): Int = moveStates.calculateMoveCount()
}
