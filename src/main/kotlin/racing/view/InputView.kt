package racing.view

object InputView {

    fun getCarsName(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return getLine()
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
