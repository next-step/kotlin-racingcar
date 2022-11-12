package study.step3.car

object CarFactory {
    fun createCars(count: Int): List<Car> {
        return List(count) {
            Car()
        }
    }
}
