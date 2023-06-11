package racing

object InputView {
    fun readCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }
}

object ResultView {
    fun printHeader() {
        println("\n실행 결과")
    }

    fun printRacingResult(cars: Cars) {
        for (car in cars.cars) {
            println("-".repeat(car.position))
        }
        println()
    }
}