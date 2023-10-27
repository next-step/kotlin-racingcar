package study.racing.domain

class Car {

    private val distance: Distance = Distance()

    fun getCarDistance(): Int {
        return this.distance.getDistance()
    }

    fun tryMoveTheCar(isMoving: Boolean) {
        if (isMoving) {
            this.distance.moveForward()
        }
    }
}
