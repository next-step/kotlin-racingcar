package racing

object CarRacing {
    fun createCars(carCount: Int) = List(carCount) { Car() }

    fun race(tryCount: Int, carCount: Int): List<List<Int>> {
        val cars = createCars(carCount)
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
}
