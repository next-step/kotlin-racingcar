package racingcar

object ResultView {

    fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            println(print(car))
        }
        println()
    }

    private fun print(car: Car): String {
        return "-".repeat(car.position)
    }
}
