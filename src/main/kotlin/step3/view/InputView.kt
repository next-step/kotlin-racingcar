package step3.view

object InputView {
    fun getNumberOfCars(): Int {
        print("자동차 대수는 몇 대 인가요?")
        return readLine()!!.toInt()
    }

    fun getNumberOfTrials(): Int {
        print("시도할 횟수는 몇 회 인가요?")
        return readLine()!!.toInt()
    }
}
