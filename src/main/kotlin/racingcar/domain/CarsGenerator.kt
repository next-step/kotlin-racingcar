package racingcar.domain

class CarsGenerator(
    private val moveStrategy: MoveStrategy
) {

    fun generate(inputCarNames: List<String>): Cars {
        val carNames = getCarNames(inputCarNames)
        val cars = carNames.map { Car(it, moveStrategy) }
        return Cars(cars)
    }

    private fun getCarNames(inputCarNames:  List<String>): List<CarName> {
        require(inputCarNames.isNotEmpty()) { "자동차 이름은 1개 이상이어야 합니다." }
        require(inputCarNames.distinct().size == inputCarNames.size) { "자동차 이름은 중복되지 않아야 합니다." }
        return inputCarNames.map { CarName(it) }
    }
}
