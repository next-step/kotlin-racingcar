package race.model

import race.view.RaceResult

class Race {
    fun run(cars: List<Car>, numberOfTry: Int): RaceResult {
        val records = mutableListOf<List<Car>>()
        var currentCars = cars.toMutableList()

        repeat(numberOfTry) {
            val movedCars = mutableListOf<Car>()

            currentCars.forEach {
                val moved = it.move()
                movedCars.add(moved)
            }

            records.add(movedCars)
            currentCars = movedCars
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
