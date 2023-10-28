package racing

object InputView {
    fun inputForRacing(): Pair<Int, Int> {
        val carCount = read("자동차 대수는 몇 대인가요?")
        val tryCount = read("시도할 횟수는 몇 회인가요?")
        return carCount to tryCount
    }

    private fun read(question: String): Int {
        println(question)
        return readln().toInt()
    }
}
