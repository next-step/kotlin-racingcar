package racingcar.domain

class Car(val name: String, initialPosition: Int = 0) : Moveable {
    var currentPosition: Int = initialPosition
        private set

    override fun go() {
        currentPosition++
    }

    override fun stop() {
    }

    fun drive(gear: Gear) {
        when (gear) {
            Gear.FORWARD -> this.go()
            Gear.STOP -> this.stop()
        }
    }

    companion object {
        fun registerCars(namesOfCars: List<String>) = List(namesOfCars.size) { Car(namesOfCars[it]) }
    }
}
