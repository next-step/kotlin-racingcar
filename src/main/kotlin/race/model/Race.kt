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

        val winners = findWinners(records.last())

        return RaceResult(records, winners)
    }

    private fun findWinners(lastRecords: List<CarRecord>): List<CarRecord> {
        val sorted = lastRecords.sorted()
        val winnerPosition = sorted.last().position

        return sorted
            .filter { it.position == winnerPosition }
    }
}
