package step4.racingcar.racingcar

data class GameResult(
    val cars: List<Car>,
    val round: Int
) {
    fun getWinner(): String {
        val cars = this.cars
        val maxCount = cars.maxOf { car -> car.getMovementCount() }
        return cars.filter { car -> car.getMovementCount() == maxCount }.joinToString { it.racerName }
    }
}
