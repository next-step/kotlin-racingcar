package racingcar

class Cars(private val cars: List<Car>) {

    fun move(): List<Car> {
        val newCars = mutableListOf<Car>()
        cars.forEach { newCars.add(it.move(true)) }
        return newCars
    }
}
