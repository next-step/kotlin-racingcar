package racing

object OutputView {

    fun printStartResult() {
        println("실행 결과")
    }

    fun printResult(cars: CarsDto) {
        cars.cars.forEach(::printCar)
        println()
    }

    fun printWinner(cars: CarsDto) {
        val winnersName = cars.cars.joinToString(", ") { it.name }
        println("${winnersName}가 최종 우승했습니다")
    }

    private fun printCar(car: CarDto) {
        val nameFormat = "${car.name} : "
        val positionFormat = "-".repeat(car.position)
        println("$nameFormat$positionFormat")
    }
}
