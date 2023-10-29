package racingcar

object InputView {

    private const val DELIMITER = ","

    fun inputRacingCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(DELIMITER).map { it.trim() }
        if (carNameCheck(carNames).not()) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        return carNames
    }

    fun inputOperationCar(): Int {
        return try {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            inputOperationCar()
        }
    }

    private fun carNameCheck(carNames: List<String>): Boolean {
        return carNames.all { it.length <= 5 }
    }
}
