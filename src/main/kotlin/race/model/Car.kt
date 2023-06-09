package race.model

data class Car(
    private var _position: Int = START_POSITION
) {
    companion object {
        const val START_POSITION = 0
    }

    val position: Int get() = _position
    fun move() {
        _position += 1
    }
}
