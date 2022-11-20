package race

class Race(
    private val randomGeneratorNumber: RandomNumberGenerator,
    private val record: Record,
) {
    fun start(carCount: Int, tryCount: Int): HashMap<Int, MutableList<Boolean>> {
        val cars = List(carCount) { Car() }
        for (i in 1..tryCount) {
            moveCars(cars)
        }
        return record.raceRecord
    }

    private fun moveCars(cars: List<Car>) =
        repeat(cars.size) { index ->
            val randomNumber = randomGeneratorNumber.generate()
            record.record(
                carIndex = index,
                movement = cars[index].move(randomNumber)
            )
        }
}
