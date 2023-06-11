package race.model

import race.view.RaceResult

class Race {
    fun run(cars: List<Car>, numberOfTry: Int): RaceResult {
        val records = mutableListOf<List<CarRecord>>()

        repeat(numberOfTry) {
            cars.forEach { it.move() }

            val copiedCars = cars.map { it.copyRecord() }
            records.add(copiedCars)
        }

        return RaceResult(records)
    }
}
