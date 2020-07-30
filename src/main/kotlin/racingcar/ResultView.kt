package racingcar

class ResultView(private val time: Int, private val cars: List<Car>) {
    fun view() {
        println("${time}번째 시도 입니다")
        cars.forEach { println("${it.num}번차 : " + makeResultCarMove(it)) }
        println()
    }

    private fun makeResultCarMove(car: Car): String = "-".repeat(car.position)
}
