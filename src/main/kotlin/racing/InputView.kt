package racing

object InputView {

    fun readCarCount(): Int? {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("유효한 값이 아닙니다.")
    }

    fun readRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("유효한 값이 아닙니다.")
    }
}
