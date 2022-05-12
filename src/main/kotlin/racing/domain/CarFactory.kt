package racing.domain

class CarFactory(
    private val carMaxPower: Int = DEFAULT_MAX_POWER,
    private val powerStrategy: PowerStrategy = RandomPowerStrategy(carMaxPower)
) {
    fun createCars(carNames: List<String>): List<Car> {
        checkValidation(carNames)

        return carNames.map { name ->
            Car(name = name, powerStrategy = powerStrategy)
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun checkValidation(carNames: List<String>) {
        require(carNames.all { it.count() <= MAX_NAME_LENGTH }) { "이름은 ${MAX_NAME_LENGTH}자 이하로 가능합니다." }
    }

    companion object {
        private const val DEFAULT_MAX_POWER = 10
        private const val MAX_NAME_LENGTH = 5
    }
}
