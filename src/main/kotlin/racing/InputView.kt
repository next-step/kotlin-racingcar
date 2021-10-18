package racing

object InputView {

    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return getInt()
    }

    fun getRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getInt()
    }

    private fun getInt(): Int {
        return getLine().toIntOrNull() ?: throw IllegalArgumentException("정수 값을 입력해주세요")
    }

    private fun getLine(): String {
        return readLine() ?: throw IllegalArgumentException("null은 input으로 허용되지 않습니다")
    }
}
