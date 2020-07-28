package racingcar

object InputView {
    fun getCarNum(): Int {
        println("자동차 대수는 몇 대인가요?")
        return checkMinus(inputInt())
    }

    fun getMoveTime(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return checkMinus(inputInt())
    }

    private fun inputInt(): Int {
        try {
            return readLine()!!.toInt()
        } catch (e: Exception) {
            throw NumberFormatException("숫자를 입력해주세요!!")
        }
    }

    private fun checkMinus(int: Int): Int {
        if (int < 0) {
            throw Exception("마이너스를 입력하지 마세요!!")
        }
        return int
    }
}
