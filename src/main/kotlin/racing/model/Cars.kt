package racing.model

class Cars(
    val cars: List<Car>
) {

    fun moveForward(movingStrategy: MovingStrategy) {
        cars.forEach { it.moveForward(movingStrategy) }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position() }
        return cars.filter { it.position() == maxPosition }
    }

    companion object {
        private const val NAME_DELIMITER = ","

        fun of(names: String): Cars {
            validateNotBlank(names)

            val splitNames = names.split(NAME_DELIMITER)
            val cars = splitNames.map { Car(Name(it)) }

            return Cars(cars)
        }

        private fun validateNotBlank(names: String) {
            require(names.isNotBlank()) { "이름 목록이 공백일 수 없습니다." }
        }
    }
}
