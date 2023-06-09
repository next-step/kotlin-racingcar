package racingcar

private const val CARNUM_STRING = "자동차 대수는 몇 대인가요?"

private const val TRYNUM_STRING = "시도할 횟수는 몇 회인가요?"

object InputView {
    fun getCarNum(): Int {
        println(CARNUM_STRING)
        return readLine()!!.toInt()
    }

    fun getTryNum(): Int {
        println(TRYNUM_STRING)
        return readLine()!!.toInt()
    }
}
