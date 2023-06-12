package race.domain

class Race {
    fun run(cars: List<Car>, numberOfTry: Int): RaceResult {
        val records = mutableListOf<List<Car>>()
        var currentCars = cars.toMutableList()

        repeat(numberOfTry) {
            val movedCars = currentCars.map { it.move() }
            records.add(movedCars)
            currentCars = movedCars.toMutableList()
        }

        return RaceResult(records)
    }
}
