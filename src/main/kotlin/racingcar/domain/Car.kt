package racingcar.domain

class Car(val name: String) : Moveable {
    var currentPosition: Int = 0
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
        fun registerCars(namesOfCars: List<String>) = Array(namesOfCars.size) { Car(namesOfCars[it]) }.toList()

        fun getFurthestCars(cars: List<Car>): List<Car> {
            val max = cars.maxOf { it.currentPosition }
            return cars.filter { it.currentPosition == max }
        }
    }
}
