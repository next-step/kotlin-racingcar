package racing_car

object ResultView {

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printPosition(cars: List<Car>) {
        cars.forEach { println("-".repeat(it.position)) }
        println()
    }
}
