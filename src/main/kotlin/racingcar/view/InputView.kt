object InputView {
    private const val FIRST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val SECOND_QUESTION = "시도할 횟수는 몇 회인가요?"

    fun getCarNames(): List<String> {
        println(FIRST_QUESTION)
        return readLine()!!.split(",")
    }

    fun getTryCount(): Int {
        println(SECOND_QUESTION)
        return readLine()!!.toInt()
    }
}
