package step4.racingcar.racingcar

data class GameResult(
    val cars: List<Car>,
    val round: Int
) {
    fun getWinners(): List<String> {
        val cars = this.cars
        val maxCount = cars.maxOf { car -> car.getMovementCount() }
        return cars.filter { car -> car.getMovementCount() == maxCount }.map { it.racerName }
    }
}
