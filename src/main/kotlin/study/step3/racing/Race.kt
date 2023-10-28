package study.step3.racing

import study.step3.domain.Car
import study.step3.inteface.MoveStrategy
import study.step3.ui.ResultView

class Race(carCount: Int, private val moveCount: Int, private val moveStrategy: MoveStrategy) {
    private val cars = List(carCount) { Car() }

    fun run() {
        repeat(moveCount) {
            cars.forEach { car ->
                val shouldMove = moveStrategy.shouldMove()
                car.move(shouldMove)
            }
            ResultView.displayCars(cars)
        }
    }

    fun getCarPositions(): List<Int> {
        return cars.map { it.position }
    }
}
