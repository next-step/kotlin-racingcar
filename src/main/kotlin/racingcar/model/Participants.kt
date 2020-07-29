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

    fun findWinner(): List<Car> = participants.filter { it.isWinner(findMaxPosition()) }

    override fun toString() = participants.joinToString("") { "${it.getName()} ${it.getMovingPath()}\n" }

    private fun findMaxPosition(): Int = participants.max()?.position ?: 0

    companion object {
        private const val PARTICIPANTS_DELIMITER = ","
    }
}
