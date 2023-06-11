package race

import race.view.RaceResult

class Race(
    private val cars: List<Car>,
    private val numberOfTry: Int
) {
    fun run(): RaceResult {
        val records = mutableListOf<List<CarRecord>>()

        repeat(numberOfTry) {
            cars.forEach { it.move() }

            val copiedCars = cars.map { it.copyRecord() }
            records.add(copiedCars)
        }

        return RaceResult(records)
    }
}
