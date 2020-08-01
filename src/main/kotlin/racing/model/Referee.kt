package racing.model

class Referee {
    fun getWinner(cars: List<Car>): List<Car> {
        val max = cars.map { it.raceResult }.max() ?: 0

        return cars.filter { it.isIn(max) }
    }
}
