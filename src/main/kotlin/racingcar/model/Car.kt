package racingcar.model

class Car(val name: String) {
    var position: Int = 0
        private set

    fun stepForward(move: Boolean) {
        if (move) position++
    }

    fun moveTo(position: Int) {
        this.position = position
    }
}
