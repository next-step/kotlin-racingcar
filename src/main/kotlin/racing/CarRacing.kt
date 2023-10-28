package racing

class CarRacing private constructor(carCount: Int) {
    private val cars = List(carCount) { Car() }

    private fun race(tryCount: Int): List<List<Int>> {
        return List(tryCount) {
            cars.racePerRound()
            cars.recordRacingResultPerRound()
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop()
        }
    }

    private fun List<Car>.recordRacingResultPerRound() = map { it.position }

    companion object {
        fun race(carCount: Int, tryCount: Int): List<List<Int>> {
            return CarRacing(carCount).race(tryCount)
        }
    }
}
