package step3.domain.car

object CarFactory {
    fun createCars(carCount: Int, carMovePointDecider: CarMovePointDecider): List<Car> {
        return List(carCount) {
            i ->
            Car(i, carMovePointDecider)
        }
    }
}
