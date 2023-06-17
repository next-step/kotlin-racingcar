package race.model

class Winner(private val cars: List<Car>) {
    fun getWinner(): String = cars.maxOf { it.position }.let {
        cars.filter { car -> car.position == it }.joinToString { it.name }
    }
}
