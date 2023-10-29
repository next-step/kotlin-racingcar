package racingcar.domain.car

class Car {
    var position: Int = 0
        private set

    fun move(amount: Int) {
        position += amount
    }
}
