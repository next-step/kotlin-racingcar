package racingCar.domain

data class Car(var position: Position = Position()) {
    fun move() {
        this.position = position.increase()
    }
}
