package racing.domain

class Winner(private val cars: Cars) {

    fun win(): List<Car> = cars.isWinner()
}
