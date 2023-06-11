package step3

object InputView {
    fun carCount(): Int {
        print("자동차 대수는 몇 대인가요?\n")
        return requireNotNull(readLine()).toInt()
    }

    fun runCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return requireNotNull(readLine()).toInt()
    }
}
