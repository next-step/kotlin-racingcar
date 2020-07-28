package racingcar

class ResultView(private val time: Int, private val cars: List<Car>) {
    fun view() {
        println("${time}번째 시도 입니다")
        for (car in cars) {
            println("${car.getNum()}번차 : " + resultCarMove(car))
        }
        println()
    }

    private fun resultCarMove(car: Car): String = "-".repeat(car.getMove())
}
