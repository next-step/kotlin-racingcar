package racing.dto

class Winners(private val cars: List<Car>) {
    fun pickWinners(): List<Car> {
        val maxDistance: Int = cars.maxOf { car -> car.turnOfPosition.last() }
        return cars.filter { car ->
            car.turnOfPosition.last() >= maxDistance
        }
    }
}
