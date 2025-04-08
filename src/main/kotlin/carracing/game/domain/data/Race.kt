package carracing.game.domain.data

class Race(
    val cars: List<Car>,
) {
    var round: Int = 0
        private set

    fun advanceRace() {
        cars.forEach {
            it.move()
        }
        round++
    }

    fun getWinners(): List<Car> = cars.filter { car -> car.position == cars.maxOf { it.position } }
}
