package racing

data class Car(private var _position: Int = 1) {
    val position get() = _position

    fun moveOrStop(random: Int) {
        if (isMove(random)) {
            move()
        }
    }

    private fun isMove(random: Int) = random >= 4

    private fun move() {
        _position += 1
    }
}
