package racing

object InputView {
    fun readCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readlnOrNull()?.toInt() ?: 0
        require(carCount >= 0) { "자동차 대수가 음수입니다." }
        return carCount
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readlnOrNull()?.toInt() ?: 0
        require(tryCount >= 0) { "시도할 횟수가 음수입니다." }
        return tryCount
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
