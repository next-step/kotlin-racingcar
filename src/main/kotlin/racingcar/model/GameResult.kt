package racingcar.model

class GameResult(val histories: List<RacingHistory>) {
    fun getWinners(): List<Car> {
        val cars = histories.last().cars
        val maxPosition = cars.maxByOrNull { it.position }?.position
        return cars.filter { it.position == maxPosition }
    }
}
