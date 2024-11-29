package racingcar.view

object InputView {
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return requireNotNull(readlnOrNull()?.split(","))
    }

    fun inputMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getNumber(readlnOrNull())
    }

    private fun getNumber(input: String?): Int {
        val number = input?.toIntOrNull()
        requireNotNull(number) { "입력한 값이 숫자가 아닙니다." }
        return number
    }
}
