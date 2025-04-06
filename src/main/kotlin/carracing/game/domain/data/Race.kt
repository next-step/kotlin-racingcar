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
}
