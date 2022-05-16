package racing.domain

class MockFirstCarMoreMovingStepper : CarMovingStepper {
    override fun step(cars: List<Car>) {
        val firstCar = cars.get(0)
        firstCar.movePosition()
    }
}
