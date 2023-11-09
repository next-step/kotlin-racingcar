package carRace.domain

interface CarsProvider {

    fun provide(carMovingStrategy: CarMovingStrategy): List<Car>

    class ManualCarsProvider(private val carNames: List<String>) : CarsProvider {
        override fun provide(carMovingStrategy: CarMovingStrategy): List<Car> =
            carNames.map { Car(driverName = it, _traveled = 0, carMovingStrategy = carMovingStrategy) }
    }
}
