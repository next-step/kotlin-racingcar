package racingcar

object ResultView {

    fun printPositionsHeader() {
        println("실행 결과")
    }

    fun printPositions(cars: List<Car>) {
        val positions = cars.joinToString(separator = "\n", postfix = "\n") { "-".repeat(it.position()) }
        println(positions)
    }
}
