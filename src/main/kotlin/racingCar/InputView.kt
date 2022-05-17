package racingCar

class InputView() {
    fun askCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toIntOrThrow()
    }

    fun askTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrThrow()
    }

    private fun String.toIntOrThrow() = toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
}
