package racingcar.domain

class CarsGenerator(
    private val moveStrategy: MoveStrategy
) {

    fun generate(inputCarNames: String): Cars {
        val carNames = getCarNames(inputCarNames)
        val cars = carNames.map { Car(it, moveStrategy) }
        return Cars(cars)
    }

    private fun getCarNames(inputCarNames: String): List<CarName> {
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
