package racingCar.view

import racingCar.domain.Car

object OutputView {

    private const val ASK_CAR_COUNT = "자동차 대수는 몇 대인가요?"
    private const val ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val EXECUTE_RESULT = "\n실행 결과"
    private const val CAR = "="

    fun printCarCount() = println(ASK_CAR_COUNT)
    fun printTryCount() = println(ASK_TRY_COUNT)
    fun printExecuteResult() = println(EXECUTE_RESULT)

    fun printCar(carList: List<Car>) {
        carList.forEach { car: Car -> println(CAR.repeat(car.moveCount)) }
        println()
    }

}
