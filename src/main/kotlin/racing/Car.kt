package racing

private const val DEFAULT_POSITION = 1
private const val MINIMUM = 4
private const val MOVING_DISTANCE = 1

data class Car(val name: String, private var _position: Int = DEFAULT_POSITION) {
    val position: Int get() = _position

    fun moveOrStop(random: Int) {
        if (isMove(random)) {
            move()
        }
    }

    private fun isMove(random: Int): Boolean = random >= MINIMUM

    private fun move() {
        _position += MOVING_DISTANCE
    }
}
