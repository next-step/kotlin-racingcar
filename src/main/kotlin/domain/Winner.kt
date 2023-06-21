package domain

class Winner(private val cars: List<Car>) {

    private val maxPosition = cars.maxOf { it.position }

    fun getWinner(): List<Car> = cars.filter { it.position == maxPosition }
}
