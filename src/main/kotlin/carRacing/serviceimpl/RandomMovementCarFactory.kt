package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.view.CarInfo

class RandomMovementCarFactory : DefaultCarFactory() {
    override fun createCars(carCount: Int): List<Car> =
        List(carCount) { Car(movementController = RandomMovementController()) }

    override fun createCars(carInfoList: List<CarInfo>): List<Car> {
        carInfoList.filter { it.isChangeableMovementController() }
            .forEach { it.movementController = RandomMovementController() }

        return super.createCars(carInfoList)
    }
}
