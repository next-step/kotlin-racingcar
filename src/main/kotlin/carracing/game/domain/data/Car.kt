package carracing.game.domain.data

private const val INITIAL_POSITION = 0
private const val MIN_NUMBER_TO_MOVE = 4

data class Car(
    private var _position: Int = INITIAL_POSITION,
) {
    val position: Int get() = _position

    fun move(number: Int) {
        if (number >= MIN_NUMBER_TO_MOVE) {
            _position++
        }
    }
}
