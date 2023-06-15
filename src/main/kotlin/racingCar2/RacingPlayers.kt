package racingCar2

class RacingPlayers(
    private val cars: List<Car>
) {
    fun getWinners(): List<String> {
        return cars.filter { it.position == this.getMaxPosition() }.map { it.name }
    }

    private fun getMaxPosition(): Int {
        return cars.maxOf { it.position }
    }
}