package racingCar.domain

class Car {
    private var position = Position()
    fun move() {
        this.position = position.increase();
    }

}
