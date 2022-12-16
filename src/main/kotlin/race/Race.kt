package race

class Race(private val randomGeneratorNumber: RandomNumberGenerator) {
    fun start(carNames: List<String>, tryCount: Int): Record {
        val cars: List<Car> = carNames.map { Car(it) }
        val snapShots = mutableListOf<SnapShot>()

        repeat(tryCount) { round ->
            val movedCars = moveCars(cars)
            val copiedCars = movedCars.map { car -> car.copy() }
            val snapShot = SnapShot(
                round = round,
                carNames = copiedCars.map { car -> car.name },
                carMovements = copiedCars.map { car -> car.movements }
            )
            snapShots.add(snapShot)
        }
        return Record(snapShots)
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
