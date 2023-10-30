package study.step3.racing

import study.step3.domain.Car
import study.step3.inteface.MoveStrategy
import study.step3.ui.ResultView

class Race private constructor(private val cars: List<Car>, private val moveCount: Int, private val moveStrategy: MoveStrategy) {

    constructor(carCount: Int, moveCount: Int, moveStrategy: MoveStrategy) :
        this(List(carCount) { Car() }, moveCount, moveStrategy)

    init {
        require(cars.isNotEmpty()) { "자동차 대수는 1대 이상이어야 합니다." }
        require(moveCount > 0) { "시도할 횟수는 1회 이상이어야 합니다." }
    }

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
