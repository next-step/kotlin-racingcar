package racingcar

class Car(var score: Int = 0) {
    fun move(canMove: Boolean) {
        if (canMove) {
            score++
        }
    }
}
