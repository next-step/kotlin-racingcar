package racingcar

class Car(position: Int = 1) {
    var position = position
        private set

    fun move(condition: Int) {
        if (condition >= 4) {
            position++
        }
    }
}
