package race.model

import race.view.RaceResult

class Race {
    fun run(cars: List<Car>, numberOfTry: Int): RaceResult {
        val records = mutableListOf<List<Car>>()
        var currentCars = cars.toMutableList()

        repeat(numberOfTry) {
            val movedCars = currentCars.map { it.move() }
            records.add(movedCars)
            currentCars = movedCars.toMutableList()
        }

        val winners = findWinners(records.last())

        return RaceResult(records, winners)
    }

    private fun findWinners(lastRecords: List<Car>): List<Car> {
        val winnerPosition = lastRecords.maxByOrNull { it.position }?.position

        return lastRecords
            .filter { it.position == winnerPosition }
    }
}
