package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.service.CarFactory
import carRacing.service.MovementController
import carRacing.view.CarInfo

open class DefaultCarFactory : CarFactory {
    override fun createCars(carCount: Int): List<Car> = throw NotImplementedError()

    /*
    * CarInfo의 movementController는 null이 넘어오지 않도록 DefaultCarFactory를 상속받는 클래스에서 구현해야 한다.
    * Ex) RandomMovementCarFactory
     */
    override fun createCars(carInfoList: List<CarInfo>): List<Car> {
        return carInfoList.map { info -> Car(info.name, info.movementController!!) }
    }
}
