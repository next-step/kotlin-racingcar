package racingcar.view

object InputView {

    private const val DELIMITER = ","

    fun inputRacingCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputValue = readln()
        require(inputValue.isNotBlank()) { "입력값이 없습니다." }
        return inputValue.split(DELIMITER).map { it.trim() }
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
}
