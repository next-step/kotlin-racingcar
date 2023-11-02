package carRacing.serviceimpl

import carRacing.domain.Car

class RandomMovementCarFactory : DefaultCarFactory() {
    override fun createCars(carCount: Int): List<Car> = List(carCount) { Car(RandomMovementController()) }
}
