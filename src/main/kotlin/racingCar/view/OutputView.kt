package racingCar.view

import racingCar.domain.Car

object OutputView {

    private const val ENTER_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val EXECUTE_RESULT = "\n실행 결과"
    private const val CAR = "="
    private const val COLON = " : "

    fun printCarName() = println(ENTER_CARS_NAME)
    fun printTryCount() = println(ASK_TRY_COUNT)
    fun printExecuteResult() = println(EXECUTE_RESULT)

    fun printCar(carList: List<Car>) {
        carList.forEach { car: Car -> println(car.name + COLON + CAR.repeat(car.moveCount)) }
        println()
    }
}
