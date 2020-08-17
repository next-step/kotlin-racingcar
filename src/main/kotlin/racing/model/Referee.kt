package racing.model

class Referee {
    fun getWinner(numberOfTrials: Int, cars: List<Car>): List<Car> {
        val max = cars.map { it.takeRaceHistory(numberOfTrials) }.max() ?: 0

        return cars.filter { it.isIn(max) }
    }
}
