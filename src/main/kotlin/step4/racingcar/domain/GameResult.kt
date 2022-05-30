package step4.racingcar.domain

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
