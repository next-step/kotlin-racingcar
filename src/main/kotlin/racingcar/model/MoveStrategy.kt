package racingcar.model

class MoveStrategy(private val numberGenerator: NumberGenerator) {
    fun isMovable(): Boolean {
        return numberGenerator.getNumber() > THRESHOLD
    }

    companion object {
        private const val THRESHOLD = 4
    }
}
