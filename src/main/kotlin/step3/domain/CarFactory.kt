package step3.domain

class CarFactory {
    fun createCars(createCarNumber: Int): List<Car> = (0 until createCarNumber).map { Car() }
}
