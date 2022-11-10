package study.step3.car

object CarFactory {
    fun createCars(count: Int): List<Car> {
        return (1..count).map { Car() }
    }
}
