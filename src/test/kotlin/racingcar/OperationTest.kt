package racingcar

import io.kotest.core.spec.style.FunSpec

class OperationTest : FunSpec() {

    init {
        test("자동차를 생성한다.") {
            val carCount = 3
            val cars = Operation.initCar(carCount)
            assert(cars.size == carCount)
        }

        test("자동차를 이동한다.") {
            val carCount = 3
            val cars = Operation.initCar(carCount)
            val movedCars = Operation.moveCar(cars)
            assert(movedCars.size == carCount)
        }
    }
}
