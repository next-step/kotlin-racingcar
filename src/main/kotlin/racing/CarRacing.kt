package racing

object CarRacing {
    fun createCars(carCount: Int) = List(carCount) { Car() }

    fun race(tryCount: Int, carCount: Int): List<List<Int>> {
        val cars = createCars(carCount)
        return List(tryCount) {
            cars.racePerRound()
        }
    }

    private fun List<Car>.racePerRound(): List<Int> {
        forEach { car ->
            car.moveOrStop()
        }
        return recordResult()
    }

    private fun List<Car>.recordResult() = map { it.position }
}
