package next.step.racing.domain

import next.step.racing.util.DrivingStrategy

data class Cars(var cars: List<Car>) {
    companion object {
        private val DEFAULT_POSITION = Position(0)
        fun from(count: Int, pos: Position = DEFAULT_POSITION): Cars = Cars((1..count).map { Car(pos) })
    }

    fun move(drivingStrategy: DrivingStrategy): Cars {
        cars = cars.map { car -> car.move(drivingStrategy) }
        return this
    }

    fun positions(): List<Int> = cars.map { car -> car.position() }
}
