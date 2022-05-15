package racingcar.domain.car

import racingcar.domain.GasStation

class Cars(
    racingCarNames: String
) {
    val values: List<Car>
    private val gasStation: GasStation = GasStation()

    init {
        val names = racingCarNames.split(REGEX)
            .map { Name(it) }

        validateDuplicate(value = names)

        this.values = names.map { Car(it) }
    }

    private fun validateDuplicate(value: List<Name>) {
        if (value.size != value.toSet().size) {
            throw IllegalArgumentException("자동차 이름은 서로 중복될 수 없습니다.")
        }
    }

    fun race() = values.forEach { car -> car.fillGasAndForward(gasStation.getRandomGas()) }

    companion object {
        private const val REGEX = ","
    }
}
