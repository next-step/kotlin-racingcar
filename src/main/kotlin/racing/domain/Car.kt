package racing.domain

data class Car(val name: String, private var _position: Int = 0) {

    val position: Int
        get() = _position

    fun move(num: Int) {
        if (num >= FORWARD_MOVE) {
            _position++
        }
    }

    companion object {
        const val FORWARD_MOVE: Int = 4
    }
}
