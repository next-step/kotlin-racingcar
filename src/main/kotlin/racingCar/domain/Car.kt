package racingCar.domain

class Car {
    var position: Int = 0
        private set

    fun move() {
        position += 1
    }
}
