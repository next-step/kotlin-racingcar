package step3.view

object InputView {
    fun getCarsNumber(): Int {
        print("자동차 대수는 몇 대 인가요?")
        return readLine()!!.toInt()
    }

    fun getRunsNumber(): Int {
        print("시도할 횟수는 몇 회 인가요?")
        return readLine()!!.toInt()
    }
}
