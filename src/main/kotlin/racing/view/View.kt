package racing.view

import racing.domain.Cars

object InputView {
    private const val CAR_NAME_DELIMITER = ","

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readlnOrNull() ?: throw IllegalArgumentException("한 대이상 자동차가 필요합니다.")
        return names.split(CAR_NAME_DELIMITER)
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readlnOrNull()?.toInt() ?: 0
        require(tryCount >= 0) { "시도할 횟수가 음수입니다." }
        return tryCount
    }
}

object ResultView {
    private const val CAR_POSITION = "-"
    private const val WINNER_DELIMITER = ", "

    fun printHeader() {
        println("\n실행 결과")
    }

    fun printRacingResult(raceResult: List<Cars>) {
        raceResult.forEach {
            printCars(it)
        }
    }

    fun printWinners(cars: Cars) {
        val winners = cars.getWinners().joinToString(WINNER_DELIMITER)
        println("${winners}가 최종 우승했습니다.")
    }

    private fun printCars(cars: Cars) {
        cars.forEach {
            val carPosition = CAR_POSITION.repeat(it.position)
            println("${it.name} : $carPosition")
        }
        println()
    }
}
