package study.racing.car

class CarRanker {
    fun getWinners(cars: List<Car>): List<Car> {
        val sorted = cars.sortedByDescending { it.totalMoved }
        val greatestScore = sorted.first().totalMoved
        return sorted.filter { it.totalMoved == greatestScore }
    }
}
