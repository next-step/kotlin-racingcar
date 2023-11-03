package racing.domain

interface CarRepository {
    fun createCar(name: String): Car

    fun createCars(names: List<String>): List<Car>
}
