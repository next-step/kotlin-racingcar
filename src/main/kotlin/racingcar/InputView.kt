package racingcar

object InputView {

    fun getCarNumber(): Int {
        print("자동차 대수는 몇대인가요? ")
        return readLine()!!.toInt()
    }

    fun getPlayTime(): Int {
        print("시도할 횟수는 몇회인가요? ")
        return readLine()!!.toInt()
    }
}
