package racing.domain

internal class RacingCars(val cars: List<Car>, private val movable: Movable) {

    val winners: List<Car>
        get() {
            val maxCar = this.cars.maxBy(Car::position)
            return this.cars.filter { it.position == maxCar!!.position }
        }

    fun nextRound() {
        this.cars.forEach { it.tryMove(this.movable) }
    }
}
