package racingcar.domain

class Car {
    var position: Int = 0
        private set

    fun move(condition: Int) {
        if (condition >= 4) {
            position++
        }
    }
}
