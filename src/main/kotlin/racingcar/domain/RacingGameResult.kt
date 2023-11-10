package racingcar.domain

class RacingGameResult(val cars: List<Car>) {

    fun getWinners(): List<Car> {
        val maxLocation = cars.maxBy { it.location }.location
        return cars.filter { it.location == maxLocation }
    }
}
