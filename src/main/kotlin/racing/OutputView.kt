package racing

object OutputView {

    fun printStartResult() {
        println("실행 결과")
    }

    fun printResult(cars: Cars) {
        cars.cars.forEach(::printCar)
        println()
    }

    private fun printCar(car: Car) {
        val nameFormat = "${car.name.value} : "
        val positionFormat = (1..car.position.value).joinToString("") { "-" }
        println("$nameFormat$positionFormat")
    }
}
