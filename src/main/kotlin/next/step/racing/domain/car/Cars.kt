package next.step.racing.domain.car

import next.step.racing.util.DrivingStrategy

data class Cars(var cars: List<Car>) {

    fun move(drivingStrategy: DrivingStrategy): Cars {
        cars.forEach { it.move(drivingStrategy) }
        return this
    }

    fun records(): List<CarRecord> = cars.map { CarRecord(it.name(), it.position()) }

    fun winners(): List<String> = fastest().map { it.name() }

    private fun fastest(): List<Car> = cars.filter { it.isAt(maxPosition()) }

    private fun maxPosition() = cars.maxOf { it.pos }

    companion object {
        private val DEFAULT_POSITION = CarPosition(0)

        fun from(names: CarNames, pos: CarPosition = DEFAULT_POSITION): Cars =
            Cars(names.names.map { Car(name = it, pos = pos) })
    }
}
