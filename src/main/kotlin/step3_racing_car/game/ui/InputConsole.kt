package step3_racing_car.game.ui

interface InputReceiver {
    fun receive(): String?
}

class CommandLineReceiver : InputReceiver {
    override fun receive(): String? {
        return readLine()
    }
}

class InputConsole(private val receiver: InputReceiver) {
    fun run(): Pair<Int, Int> {
        print("자동차 대수는 몇 대인가요?")
        val numOfCar = receiver.receive()
        print("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = receiver.receive()

        isValid(numOfCar)
        isValid(numOfGame)

        return Pair(numOfCar!!.toInt(), numOfGame!!.toInt())
    }

    private fun isValid(num: String?) {
        require(!num.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }

        var numToInt = 0
        try {
            numToInt = num.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값 : $num, 정수형을 입력해 주세요.")
        }

        require(numToInt > 0) { "입력값은 1 이상이어야만 합니다." }
    }
}
