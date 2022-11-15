package racing.domain

class GameResult(private val cars: List<Car>) {
    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }
}
