package carracing.game.domain.data

private const val INITIAL_POSITION = 0

data class Car(
    var position: Int = INITIAL_POSITION,
) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }
}
