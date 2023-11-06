package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.view.CarInfo

/*
* RandomMovementController를 주입하는 CarFactory
* */
class RandomMovementCarFactory : DefaultCarFactory() {
    fun createCarList(carNameList: List<String>): List<Car> {
        val carInfoList: List<CarInfo> = carNameList.map { CarInfo(it, RandomMovementController()) }

        return super.createCars(carInfoList)
    }
}
