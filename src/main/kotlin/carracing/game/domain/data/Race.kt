package carracing.game.domain.data

class Race(
    carsNames: List<String>,
    carsFactory: CarsFactory = CarsFactory,
    private val totalRounds: Int,
) {
    var round: Int = 0
        private set

    val cars: List<Car> = carsFactory.from(carsNames)

    val winners: List<Car>
        get() {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { car -> car.position == maxPosition }
        }

    fun generateRaceSequence(): Sequence<Race> =
        sequence {
            repeat(totalRounds) {
                advanceRace()
                yield(this@Race)
            }
        }

    private fun advanceRace() {
        cars.forEach {
            it.move()
        }
        round++
    }
}
