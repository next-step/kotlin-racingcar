package racingcar.model

data class WinnersReader(val cars: List<Car>) {
    fun findWinners(): List<Car> {
        return cars.filter { it.getPosition() == getMaxPosition() }
    }

    private fun getMaxPosition(): Int {
        return cars.map { it.getPosition() }.max() ?: 0
    }
}
