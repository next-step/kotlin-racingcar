package domain

class Winner(private val cars: List<Car>) {

    private val maxPosition = cars.maxOf { it.position }

    fun getWinner(): String = cars.filter { it.position == maxPosition }.joinToString { it.name }
}
