package race

class Race(
    private val randomGeneratorNumber: RandomNumberGenerator,
    private val record: Record,
) {
    fun start(carNames: List<String>, tryCount: Int): Record {
        val cars: List<Car> = carNames.map { Car(it) }
        repeat(tryCount){ moveCars(cars) }
        return record
    }

    private fun moveCars(cars: List<Car>) =
        cars.forEach { car ->
            val randomNumber = randomGeneratorNumber.generate()
            record.record(
                carName = car.name,
                movement = car.move(randomNumber)
            )
        }
}
