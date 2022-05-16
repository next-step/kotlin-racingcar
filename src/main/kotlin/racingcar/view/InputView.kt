package racingcar.view

class InputView {
    private fun getCount(message: String, retry: Int = 1): Int = try {
        println(message)
        val res = readln().toInt()
        if (res < 1) throw NumberFormatException()
        res
    } catch (e: java.lang.NumberFormatException) {
        if (retry > 2) println("좋은 말로 할 때... s(^_^)b ")
        println("1보다 큰 정수로 입력해주세요.")
        getCount(message, retry + 1)
    }

    fun getCarCount(): Int = getCount("자동차 대수는 몇 대인가요?")

    fun getMoveCount(): Int = getCount("시도할 횟수는 몇 회인가요?")
}
