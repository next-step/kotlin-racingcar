package racing.domain

class Car(position: Int = 0) {

    var position = position
        private set

    fun move(num: Int) {
        if (num >= FORWARD_MOVE) {
            position++
        }
    }

    companion object {
        const val FORWARD_MOVE: Int = 4
    }
}
