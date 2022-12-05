package racingcar.controller

class Car(val name: String = "-", currentPosition: Int = 0) {
    var currentPosition: Int = currentPosition
        private set

    init {
        require(name.length <= 5)
        require(currentPosition >= 0)
    }

    fun move(nextMovement: Int = 1) {
        currentPosition += nextMovement
    }
}
