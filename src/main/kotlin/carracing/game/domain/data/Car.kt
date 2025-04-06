package carracing.game.domain.data

private const val INITIAL_POSITION = 0
private const val MIN_NUMBER_TO_MOVE = 4

data class Car(
    var position: Int = INITIAL_POSITION,
) {
    fun move(number: Int) {
        if (number >= MIN_NUMBER_TO_MOVE) {
            position++
        }
    }
}
