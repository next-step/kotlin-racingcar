package study.step3.view

object InputView {

    fun readNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toIntOrNull() ?: throw NumberFormatException("유효한 숫자를 입력하세요.")
    }

    fun readNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw NumberFormatException("유효한 숫자를 입력하세요.")
    }
}
