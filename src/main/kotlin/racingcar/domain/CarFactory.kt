package racingcar.domain

object CarFactory {
    fun createCars(createCarNumber: Int): List<Car> = (0 until createCarNumber).map { Car() }
}
