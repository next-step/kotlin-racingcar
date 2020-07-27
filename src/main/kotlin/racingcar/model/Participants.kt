package racingcar.model

import racingcar.strategy.MovingStrategy

class Participants(
    private val carCount: Int,
    private val movingStrategy: MovingStrategy
) {
    private val participants = List(carCount) { index -> Car(index + 1, movingStrategy) }

    fun processRound() {
        participants.forEach { it.moveForward() }
    }

    fun getMovingStatus() = participants.joinToString("") { "${it.getName()} ${it.getMovingPath()}\n" }
}
