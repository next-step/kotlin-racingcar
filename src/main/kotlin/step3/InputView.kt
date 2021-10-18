package step3

object InputView {
    fun getCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return getInt()
    }

    fun getRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getInt()
    }

    private fun getInt(): Int {
        val integer = getString().toIntOrNull()
        requireNotNull(integer) { "입력값은 자연수만 가능합니다." }
        return integer
    }

    private fun getString(): String {
        val string = readLine()
        requireNotNull(string) { "null값은 입력할 수 없습니다." }
        return string
    }
}
