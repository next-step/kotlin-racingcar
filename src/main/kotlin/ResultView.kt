const val PRINT_FORMAT = "-"

class ResultView {

    fun printResult(car: Car) {
        println(PRINT_FORMAT.repeat(car.getPosition()))
    }

    fun printResult(cars: List<Car>) {
        for (car in cars) {
            println(printResult(car))
        }
        println()
    }

    fun printInit() {
        println("실행 결과")
    }
}
