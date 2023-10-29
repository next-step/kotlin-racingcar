package racing

class CarRacing {
    fun race(carNames: List<String>, tryCount: Int): CarRacingResult {
        val cars = carNames.map { Car(it) }
        val results = cars.race(tryCount)
        val winners = findWinners(cars)
        return CarRacingResult(results, winners)
    }

    private fun List<Car>.race(tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            racePerRound()
            recordRacingResultPerRound()
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop(movableRange.random())
        }
    }

    private fun List<Car>.recordRacingResultPerRound(): List<Car> = map { it.copy() }

    private fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { car -> car.position == maxPosition }.map { it.name }
    }

    companion object {
        private val movableRange = 0..9
    }
}
