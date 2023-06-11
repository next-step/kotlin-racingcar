package race

import race.view.ResultData

class Race(
    private val cars: List<Car>,
    private val numberOfTry: Int
) {
    fun run(): ResultData {
        val records = mutableListOf<List<Car>>()

        repeat(numberOfTry) {
            cars.forEach { it.move() }

            val copiedCars = cars.map { it.copy() }
            records.add(copiedCars)
        }

        return ResultData(records)
    }
}
