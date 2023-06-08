package step3

class CarRacing {
    companion object {
        private const val RANDOM_RANGE = 10
    }

    private val raceRule = RaceRule()

    fun execute(
        carCount: Int,
        executeCount: Int,
    ) {
        val cars = prepareCars(carCount)

        race(
            cars = cars,
            executeCount = executeCount,
        )
    }

    private fun prepareCars(carCount: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(carCount) {
            cars.add(Car())
        }
        return cars
    }

    private fun race(
        cars: List<Car>,
        executeCount: Int
    ) {
        repeat(executeCount) {
            cars.forEach { car ->
                val raceNumber = RaceNumber.from(buildRandomNumber())
                if (raceRule.isGo(raceNumber)) {
                    car.progress()
                }

                car.showPosition()
            }

            println()
        }
    }

    private fun buildRandomNumber(): Int {
        return (Math.random() * RANDOM_RANGE).toInt()
    }
}
