package racing.domain

class Winners(val carNames: List<String>) {

    companion object {
        fun from(cars: List<Car>): Winners {
            val maxPosition = cars.maxOf { it.position }
            return Winners(cars.filter { maxPosition == it.position }.map { it.name })
        }
    }
}
