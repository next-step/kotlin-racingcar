package racing.domain

class Racing(val cars: List<Car>) {
    fun startRacing(movable: () -> Boolean): List<Car> {
        this.cars.filter { movable() }.forEach { it.move() }
        return this.cars
    }
}
