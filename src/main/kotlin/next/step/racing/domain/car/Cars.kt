package next.step.racing.domain.car

import next.step.racing.util.DrivingStrategy

data class Cars(private val cars: List<Car>) : List<Car> by cars {

    fun move(drivingStrategy: DrivingStrategy): Cars {
        forEach { it.move(drivingStrategy) }
        return this
    }

    fun records(): List<CarRecord> = map { CarRecord(it.name(), it.position()) }

    fun winners(): List<String> = maxBy { it.pos }.map { it.name() }

    private fun <R : Comparable<R>> maxBy(selector: (Car) -> R): List<Car> {
        return groupBy(selector).maxBy { it.key }.value
    }

    companion object {
        private val DEFAULT_POSITION = CarPosition(0)

        fun of(names: CarNames, pos: CarPosition = DEFAULT_POSITION): Cars =
            Cars(names.names.map { Car(name = it, pos = pos) })
    }
}
