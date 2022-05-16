package racing.domain

class CarFactory(
    private val powerStrategy: PowerStrategy = RandomPowerStrategy()
) {
    fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { name ->
            Car(name = name, powerStrategy = powerStrategy)
        }
    }
}
