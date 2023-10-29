package racing

class CarRacing private constructor(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    private fun race(tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            cars.racePerRound()
            cars.recordRacingResultPerRound()
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop(movableRange.random())
        }
    }

    private fun List<Car>.recordRacingResultPerRound(): List<Car> = map { it.copy() }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { car -> car.position == maxPosition }.map { it.name }
    }

    companion object {
        private val movableRange = 0..9

        fun race(carNames: List<String>, tryCount: Int): CarRacingResult {
            val carRacing = CarRacing(carNames)
            val results = carRacing.race(tryCount)
            val winners = carRacing.findWinners()
            return CarRacingResult(results, winners)
        }
    }
}
