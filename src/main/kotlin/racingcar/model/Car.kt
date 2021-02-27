package racingcar.model

class Car {
    var score: Int = 0
        private set

    fun move(canMove: Boolean) {
        if (canMove) {
            score++
        }
    }
}
