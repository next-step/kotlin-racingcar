package carracing.game.domain.data

class Race(
    val cars: List<Car>,
) {
    var round: Int = 0
        private set

    val winners: List<Car>
        get() {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { car -> car.position == maxPosition }
        }

    fun advanceRace() {
        cars.forEach {
            it.move()
        }
        round++
    }
}
