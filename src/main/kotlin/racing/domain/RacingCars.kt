package racing.domain

internal class RacingCars(val cars: List<Car>) {

    val winners: List<Car>
        get() {
            val maxCar: Car = this.cars.maxBy { it.position } ?: return emptyList()
            return this.cars.filter { it.equalPosition(maxCar) }
        }

    fun nextRound(movable: Movable) {
        return this.cars.forEach { it.tryMove(movable) }
    }

    fun copyCars(): List<Car> {
        return this.cars.map { car -> car.copy() }
    }
}
