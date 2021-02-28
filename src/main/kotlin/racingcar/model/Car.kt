package racingcar.model

class Car(val name: String) {
    var score: Int = 0
        private set

    fun move(canMove: Boolean) {
        if (canMove) {
            score++
        }
    }
}
