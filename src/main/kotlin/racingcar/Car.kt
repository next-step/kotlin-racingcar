package racingcar

class Car {
    var position: Int = 0
        private set

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }
}
