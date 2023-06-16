package racingcar.domain

class Cars(
    val cars: List<Car>
) {
    init {
        validateEmptyCars(cars)
        validateDuplicatedCarNames(cars)
    }

    private fun validateEmptyCars(cars: List<Car>) {
        require(cars.isNotEmpty()) {
            MESSAGE_CONDITION_CAR_COUNT
        }
    }

    private fun validateDuplicatedCarNames(cars: List<Car>) {
        val carNames = cars.map { it.carName.name }
        require(carNames.stream().distinct().count().toInt() == carNames.size) {
            MESSAGE_DUPLICATED_CAR_NAMES
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        const val MESSAGE_CONDITION_CAR_COUNT = "자동차 대수는 한 대 이상이여야 합니다."
        const val MESSAGE_DUPLICATED_CAR_NAMES = "자동차 이름이 중복됩니다."
    }
}
