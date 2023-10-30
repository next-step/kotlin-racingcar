package racingcar.model

data class Cars(
    val cars: List<Car>,
) {
    fun move(moveCondition: MoveCondition): List<Car> {
        this.cars.forEach { if (moveCondition.isMovable()) { it.move() } }
        return this.cars
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun from(carList: String): Cars {
            return Cars(carList.split(SEPARATOR).map { Car(it) })
        }

        private const val SEPARATOR = ","
    }
}
