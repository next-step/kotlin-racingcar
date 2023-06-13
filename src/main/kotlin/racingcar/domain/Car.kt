package racingcar.domain

class Car(position: Int = 0) {

    var position = position
        private set

    fun move() {
        position++
    }
}
