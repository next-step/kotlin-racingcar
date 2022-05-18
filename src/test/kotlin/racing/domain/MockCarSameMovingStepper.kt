package racing.domain

class MockCarSameMovingStepper : CarMovingStepper {
    override fun step(cars: List<Car>) {
        cars.forEach { it.movePosition() }
    }
}
