package carRacing.Domain

import carRacing.ServiceImpl.SimpleCarController

class Racing {
    fun start(carCount: Int, tryCount: Int) {
        val carList: List<Car> = SimpleCarController().createCars(carCount)

        TODO("Not yet implemented")
    }
}
