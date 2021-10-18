package racing

class OutputView {

    fun printStartResult() {
        println("실행 결과")
    }

    fun printResult(cars: Cars) {
        cars.cars.forEach(::printCar)
    }

    private fun printCar(car: Car) {
        (1..car.position.value).joinToString("") { "-" }
            .let(::println)
    }
}
