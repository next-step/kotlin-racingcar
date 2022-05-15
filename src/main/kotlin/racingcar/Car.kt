package racingcar

class Car(var movement: Int = 0) {
    fun move() {
        this.movement = movement + 1
    }
}