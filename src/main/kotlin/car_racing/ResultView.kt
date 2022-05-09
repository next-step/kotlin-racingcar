package car_racing

object ResultView {

    fun printTitle() {
        println("실행 결과")
    }

    fun printRound(cars: List<Car>) {
        cars.forEach {
            val char = "_".repeat(it.position)
            println(char)
        }
        println()
    }
}
