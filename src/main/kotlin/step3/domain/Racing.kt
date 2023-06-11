package step3.domain

class Racing(
    private val cars: List<Car>
) {
    fun race() {
        cars.forEach {
            it.move()
        }
    }

    val currentStatus: List<CurrentCarStatus>
        get() = cars.map {
            CurrentCarStatus(it.name, it.movedDistance)
        }

    fun findCurrentWinnerNames(): List<CarName> {
        val currentBestDistance = cars.maxOf { it.movedDistance }
        return cars.filter { it.movedDistance == currentBestDistance }.map { it.name }
    }
}
