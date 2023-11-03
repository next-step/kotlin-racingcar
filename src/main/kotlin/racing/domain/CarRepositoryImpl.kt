package racing.domain

object CarRepositoryImpl : CarRepository {
    override fun createCar(name: String): Car = Car(name)

    override fun createCars(names: List<String>): List<Car> = names.map { name ->
        createCar(name)
    }
}
