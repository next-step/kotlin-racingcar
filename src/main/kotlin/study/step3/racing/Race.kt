package study.step3.racing

import study.step3.domain.Car
import study.step3.inteface.MoveStrategy
import study.step3.ui.ResultView

class Race private constructor(private val cars: List<Car>, private val moveCount: Int, private val moveStrategy: MoveStrategy) {

    constructor(carCount: Int, moveCount: Int, moveStrategy: MoveStrategy) :
        this(List(carCount) { Car() }, moveCount, moveStrategy)

    fun run() {
        repeat(moveCount) {
            cars.forEach { car ->
                val shouldMove = moveStrategy.shouldMove()
                car.move(shouldMove)
            }
            ResultView.displayCars(cars)
        }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
