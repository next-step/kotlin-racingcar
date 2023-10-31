package racingcar

object ResultView {

    private const val HYPHEN = "-"
    private const val RESULT = "실행 결과"
    private const val SEMICOLON = " : "

    fun printResult(cars: Cars, operationCount: Int) {
        println(RESULT)
        repeat(operationCount) {
            cars.operateCars()
            printCarResult(cars.carList)
        }
        printWinner(cars.isWinner())
    }
    private fun printCarResult(cars: List<Car>) {
        cars.forEach { car ->
            println(print(car))
        }
        println()
    }

    private fun print(car: Car): String {
        return car.name + SEMICOLON + HYPHEN.repeat(car.position)
    }

    private fun printWinner(winners: List<String>) {
        println(winners.joinToString(",") + "가 최종 우승했습니다.")
    }
}
