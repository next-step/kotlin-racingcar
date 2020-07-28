package racingcar.model

import racingcar.strategy.MovingStrategy

data class Participants(
    private val carNames: String,
    private val movingStrategy: MovingStrategy
) {
    private val participants = carNames.split(PARTICIPANTS_DELIMITER)
        .filter { it.isNotBlank() }
        .mapIndexed { index, name ->
            Car(index + 1, name.trim(), movingStrategy)
        }

    fun processRound() {
        participants.forEach { it.moveForward() }
    }

    fun getMovingStatus() = participants.joinToString("") { "${it.getName()} ${it.getMovingPath()}\n" }

    companion object {
        private const val PARTICIPANTS_DELIMITER = ","
    }
}
