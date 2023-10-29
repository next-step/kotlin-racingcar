package racingcar

object ResultView {

    private const val HYPHEN = "-"
    private const val RESULT = "실행 결과"

    fun printResult(cars: Cars, operationCount: Int) {
        println(RESULT)
        repeat(operationCount) {
            cars.operateCars()
            printCarResult(cars.carList)
        }
    }
    private fun printCarResult(cars: List<Car>) {
        cars.forEach { car ->
            println(print(car))
        }
        println()
    }

    private fun print(car: Car): String {
        return HYPHEN.repeat(car.position)
    }
}
