package race

class Race(private val randomGeneratorNumber: RandomNumberGenerator) {
    fun start(carNames: List<String>, tryCount: Int): Record {
        val cars: List<Car> = carNames.map { Car(it) }
        val snapShots = mutableListOf<SnapShot>()

        repeat(tryCount) { round ->
            val finishedRound = startRound(round, cars)
            finishedRound.forEach { snapShots.add(it) }
        }
        return Record(snapShots)
    }

    private fun startRound(round: Int, cars: List<Car>): List<SnapShot> {
        return cars.map { moveCar(round, it) }
    }

    private fun moveCar(round: Int, car: Car): SnapShot {
        val randomNumber = randomGeneratorNumber.generate()
        val isMoved = car.move(randomNumber)
        return SnapShot(round, car.name, isMoved)
    }
}
