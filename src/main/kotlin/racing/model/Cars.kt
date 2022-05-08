package racing.model

class Cars(
    val cars: List<Car>
) {

    companion object {
        private const val MIN_CAR_COUNT = 1

        fun of(carCount: Int): Cars {
            validateMinCarCount(carCount)

            val cars = mutableListOf<Car>()
            repeat(carCount) { cars.add(Car()) }
            return Cars(cars)
        }

        private fun validateMinCarCount(carCount: Int) {
            require(carCount >= MIN_CAR_COUNT) {
                "자동차 대수는 최소 ${MIN_CAR_COUNT}대 이어야 합니다. (carCount: $carCount)"
            }
        }
    }

    fun moveForward(carMovingStrategy: MovingStrategy) {
        cars.forEach { it.moveForward(carMovingStrategy) }
    }
}
