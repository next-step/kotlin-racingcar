package racingcar.domain

data class RoundHistory(val round: Int, val cars: Cars) {
    fun getWinners() = cars.getMaxPositionCars()
}
