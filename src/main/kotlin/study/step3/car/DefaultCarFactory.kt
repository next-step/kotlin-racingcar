package study.step3.car

class DefaultCarFactory : CarFactory {
    override fun createCars(numberOfCars: Int): List<Car> {
        return List(numberOfCars) { Car() }
    }
}
