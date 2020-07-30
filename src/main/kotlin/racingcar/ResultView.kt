package racingcar

const val PRINT_FORMAT = "-"

class ResultView {

    fun printResult(car: Car) {
        println("${car.getName()}: ${PRINT_FORMAT.repeat(car.position)}")
    }

    fun printResult(cars: List<Car>) {
        for (car in cars) {
            printResult(car)
        }
        println()
    }

    fun printResult(cars: List<Car>, historyIndex: Int) {
        for (car in cars) {
            println("${car.getName()}: ${PRINT_FORMAT.repeat(car.positionHistory[historyIndex])}")
        }
        println()
    }

    fun printInit() {
        println("실행 결과")
    }

    fun printWinner(cars: List<Car>) {
        println("${cars.joinToString(NAME_SPLIT_FORMAT) { it.getName() }}가 최종 우승했습니다.")
    }
}
