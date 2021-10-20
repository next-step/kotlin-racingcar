package step3

object ResultView {
    private const val PROCESS_RESULT = "실행결과"

    fun printResult(carList: List<Car>) {
        carList.forEach {
            printMovedDistance(it)
        }
    }

    private fun printMovedDistance(car: Car) {
        println("-".repeat(car.movedDistance))
    }

    fun printProcessResultTitle() {
        println(PROCESS_RESULT)
    }
}
