package step4.model

class Referee {
    fun getWinner(cars: List<Car>): List<Car> {
        val max = cars.map { it.raceResult }.max()

        return cars.filter { it.raceResult == max }
    }
}
