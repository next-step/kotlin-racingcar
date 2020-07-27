package week1.step3

object InputView {

    fun getCarAndTryCount(): Pair<Int, Int> = readCarCount() to readTryCount()

    private fun readCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("유효한 값이 아닙니다.")
    }

    private fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException("유효한 값이 아닙니다.")
    }
}
