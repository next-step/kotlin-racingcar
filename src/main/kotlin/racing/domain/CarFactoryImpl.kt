package racing.domain

object CarFactoryImpl : CarFactory {
    override fun createCars(carNames: List<String>): List<Car> = carNames.map { name ->
        Car.of(name)
    }
}
