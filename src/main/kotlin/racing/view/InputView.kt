package racing.view

object InputView {
    fun getCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return getStringList()
    }

    private fun getStringList(): List<String> {
        return getString().split(",")
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
