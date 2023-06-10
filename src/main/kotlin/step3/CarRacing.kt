package step3

class CarRacing {
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
                car.progress()
                showPosition(car.positionValue)
            }

            println()
        }
    }

    private fun showPosition(position: Int) {
        println("-".repeat(position))
    }
}
