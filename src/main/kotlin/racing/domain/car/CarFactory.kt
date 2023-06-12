package racing.domain.car

object CarFactory {

    private const val DEFAULT_POSITION = 0

    fun createCar(name: String, position: Int = DEFAULT_POSITION): Car = Car(
        name = name,
        position = position,
    )

    fun createCars(
        carNames: List<String>,
        position: Int = DEFAULT_POSITION,
    ): List<Car> = carNames.map {
        createCar(position = position, name = it)
    }
}
