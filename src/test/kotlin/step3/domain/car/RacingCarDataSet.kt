package step3.domain.car

import step3.domain.car.name.CarNameDataSet

class RacingCarDataSet {

    companion object {
        fun testData(): RacingCar = RacingCar(CarNameDataSet.testData())
    }
}
