package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.service.CarFactory
import carRacing.view.CarInfo

/*
* RandomMovementController를 주입하는 CarFactory
* */
class RandomMovementCarFactory : CarFactory {

    override fun createCars(carInfoList: List<CarInfo>): List<Car> = carInfoList.map { info -> Car(info.name, info.movementController) }

    override fun createCarsWithNameList(carNameList: List<String>): List<Car> {
        val carInfoList: List<CarInfo> = carNameList.map { CarInfo(it, RandomMovementController()) }

        return createCars(carInfoList)
    }
}
