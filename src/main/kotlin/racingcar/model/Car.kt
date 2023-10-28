package racingcar.model

class Car(val name: String, var position: Int = 0) {
    fun stepForward(move: Boolean) {
        if (move) position++
    }
}
