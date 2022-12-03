package race

class Race(private val randomGeneratorNumber: RandomNumberGenerator) {
    fun start(carNames: List<String>, tryCount: Int): List<SnapShot> {
        val cars: List<Car> = carNames.map { Car(it) }
        val snapShots = mutableListOf<SnapShot>()

        repeat(tryCount) { round ->
            val movedCars = moveCars(cars)
            val snapShot = SnapShot(round, movedCars.map { car -> car.copy() })
            snapShots.add(snapShot)
        }
        return snapShots
    }

    private fun moveCars(cars: List<Car>): List<Car> {
        val movedCars = cars.map { car ->
            val randomNumber = randomGeneratorNumber.generate()
            car.move(randomNumber)
            car
        }
        return movedCars
    }
}
