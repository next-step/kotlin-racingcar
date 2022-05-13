package racing.domain

class CarFactory(
    private val carMaxPower: Int = DEFAULT_MAX_POWER,
    private val powerStrategy: PowerStrategy = RandomPowerStrategy(carMaxPower)
) {
    fun createCars(carNames: List<String>): RacingCars {
        return RacingCars(carNames.map { name ->
            Car(name = name, powerStrategy = powerStrategy)
        })
    }

    companion object {
        private const val DEFAULT_MAX_POWER = 10
    }
}
