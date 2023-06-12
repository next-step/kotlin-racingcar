package step3

class CarRacing {

    fun execute(
        carCount: Int,
        executeCount: Int,
    ) {
        val cars = mutableListOf<Car>()
        repeat(carCount) {
            cars.add(Car.build())
        }

        race(
            cars = cars,
            executeCount = executeCount,
        )
    }

    private fun race(
        cars: List<Car>,
        executeCount: Int
    ) {
        ResultView.start()
        repeat(executeCount) {
            cars.run()
            println()
        }
    }

    private fun List<Car>.run() {
        this.forEach { car ->
            car.progress(
                raceNumber = RaceNumber.from(RaceNumber.generateRandomNumber())
            )
            ResultView.showPosition(car.positionValue)
        }
    }
}
