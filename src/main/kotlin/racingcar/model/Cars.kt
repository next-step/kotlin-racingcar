package racingcar.model

data class Cars(
    val cars: List<Car>,
) {
    fun move() {
        this.cars.forEach { it.move() }
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun from(carList: List<String>): Cars {
            return Cars(carList.map { Car(it) })
        }
    }
}
