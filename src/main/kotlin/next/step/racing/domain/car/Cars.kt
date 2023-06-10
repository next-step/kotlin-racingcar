package next.step.racing.domain.car

import next.step.racing.util.DrivingStrategy

data class Cars(var cars: List<Car>) {
    companion object {
        private val DEFAULT_POSITION = CarPosition(0)
        fun from(names: CarNames, pos: CarPosition = DEFAULT_POSITION): Cars =
            Cars(names.names.map { Car(name = it, pos = pos) })
    }

    fun move(drivingStrategy: DrivingStrategy): Cars {
        cars = cars.map { car -> car.move(drivingStrategy) }
        return this
    }

    fun records(): List<CarRecord> = cars.map { car -> CarRecord(car.name(), car.position()) }
    fun winners(): List<String> = mostFast().map { car -> car.name() }
    private fun mostFast(): List<Car> = cars.filter { car -> car.isAt(maxPosition()) }
    private fun maxPosition() = cars.maxOf { car -> car.pos }
}
