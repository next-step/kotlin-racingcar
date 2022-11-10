package racingcar.domain

class Car : Moveable {

    var currentPosition: Int = 0
        private set

    override fun go() {
        currentPosition++
    }

    override fun stop() {

    }

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
