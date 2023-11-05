package racing.domain

interface CarFactory {
    fun createCars(carNames: List<String>): List<Car>
}
