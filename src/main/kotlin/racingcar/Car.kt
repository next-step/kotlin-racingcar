package racingcar

class Car {
    var position = 0
        private set

    fun move(movePoint: Int = (0..9).random()) {
        if (movePoint >= 0) {
            position++
        }
    }
}