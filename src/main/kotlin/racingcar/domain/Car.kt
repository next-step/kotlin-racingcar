package racingcar.domain

class Car(val name: String, position: Int = 0) {
    var position: Int = position
        private set
    fun moveForward() = this.position++
}
