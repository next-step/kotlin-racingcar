package racingcar

class Car {
    var position: Int = 0
        private set

    fun tryMove(number: Int) {
        if (number >= 4) {
            position++
        }
    }
}
