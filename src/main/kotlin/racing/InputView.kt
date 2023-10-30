package racing

object InputView {
    fun inputForRacing(): Pair<List<String>, Int> {
        val carNames = read("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").split(",")
        val tryCount = read("시도할 횟수는 몇 회인가요?").toInt()
        return carNames to tryCount
    }

    private fun read(question: String): String {
        println(question)
        return readln()
    }
}
