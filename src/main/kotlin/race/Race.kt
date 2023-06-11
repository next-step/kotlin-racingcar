package race

import race.view.ResultData

class Race(
    private val cars: List<Car>,
    private val numberOfTry: Int
) {
    fun run(): ResultData {
        val records = mutableListOf<List<CarRecord>>()

        repeat(numberOfTry) {
            cars.forEach { it.move() }

            val copiedCars = cars.map { it.copyRecord() }
            records.add(copiedCars)
        }

        return ResultData(records)
    }
}
