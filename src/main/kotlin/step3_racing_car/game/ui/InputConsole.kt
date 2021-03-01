package step3_racing_car.game.ui

class InputConsole {
    fun run(): Pair<Int, Int> {
        print("자동차 대수는 몇 대인가요?")
        val numOfCar = receive()
        print("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = receive()

        if (!isValid(numOfCar) or !isValid(numOfGame)) {
            throw java.lang.IllegalArgumentException("입력이 실패했습니다.")
        }
        return Pair(numOfCar!!.toInt(), numOfGame!!.toInt())
    }

    private fun isValid(num: String?): Boolean {
        if (num.isNullOrBlank()) {
            throw IllegalArgumentException("입력값은 null 혹은 blank 값이 될 수 없습니다.")
        }

        val numToInt: Int

        try {
            numToInt = num.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값 : $num, 정수형을 입력해 주세요.")
        }

        if (numToInt <= 0) {
            throw IllegalArgumentException("입력값은 1 이상이어야만 합니다.")
        }

        return true
    }

    private fun receive(): String? {
        return readLine()
    }
}
