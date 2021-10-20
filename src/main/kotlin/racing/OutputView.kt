package racing

object OutputView {

    fun printStartResult() {
        println("실행 결과")
    }

    fun printResult(cars: Cars) {
        cars.cars.forEach(::printCar)
        println()
    }

    fun printWinner(cars: Cars) {
        val winnersName = cars.cars.joinToString(", ") { it.name.value }
        println("${winnersName}가 최종 우승했습니다")
    }

    private fun printCar(car: Car) {
        val nameFormat = "${car.name.value} : "
        val positionFormat = (1..car.position.value).joinToString("") { "-" }
        println("$nameFormat$positionFormat")
    }
}
