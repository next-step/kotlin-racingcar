package racing.domain

internal class RacingCars(val cars: List<Car>) {

    val winners: List<Car>
        get() {
            val maxCar: Car = this.cars.maxWith(compareBy { it.position })
                ?: return emptyList()

            return this.cars.filter { it.equalPosition(maxCar) }
        }

    fun nextRound(movable: Movable) {
        this.cars.forEach { it.tryMove(movable) }
    }
}
