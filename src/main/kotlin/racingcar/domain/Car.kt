package racingcar.domain

class Car : Moveable {

    private var currentPosition: Int = 0

    override fun go() {
        currentPosition++
    }

    override fun stop() {
        currentPosition
    }

    fun getCurrentPosition() = currentPosition

    companion object {
        fun registerCars(numberOfCars: Int) = Array(numberOfCars) { Car() }

        fun Car.drive(gear: Gear) {
            when (gear) {
                Gear.FORWARD -> this.go()
                Gear.STOP -> this.stop()
            }
        }
    }
}
