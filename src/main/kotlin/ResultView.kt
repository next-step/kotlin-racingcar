const val PRINT_FORMAT = "-"

class ResultView {

    fun printResult(car: Car) {
        println(PRINT_FORMAT.repeat(car.getPosition()))
    }

    fun printResult(positions: List<Int>) {
        for (position in positions) {
            println(PRINT_FORMAT.repeat(position))
        }
        println()
    }

    fun printInit() {
        println("실행 결과")
    }
}
