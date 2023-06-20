package racingcar.car

class CarsGenerator(
    private val inputCarNames: String,
    private val moveStrategy: MoveStrategy
) {

    fun generate(): Cars {
        val carNames = getCarNames()
        val cars = carNames.map { Car(it, moveStrategy) }
        return Cars(cars)
    }

    private fun getCarNames(): List<CarName> {
        val carNamesString = inputCarNames.split(CAR_NAME_DELIMITER)
        require(carNamesString.isNotEmpty()) { "자동차 이름은 1개 이상이어야 합니다." }
        val carNames = carNamesString.map { CarName(it.trim()) }.toList()
        require(carNames.distinct().size == carNames.size) { "자동차 이름은 중복되지 않아야 합니다." }
        return carNames
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
