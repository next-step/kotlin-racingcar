package step4_racing_car_winner.game.ui

interface InputReceiver {
    fun receive(): String?
}

class CommandLineReceiver : InputReceiver {
    override fun receive(): String? {
        return readLine()
    }
}

class InputConsole(private val receiver: InputReceiver) {
    fun run(): Pair<String, Int> {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val nameOfCars = receiver.receive()
        print("시도할 횟수는 몇 회인가요?")
        val numOfGame: String? = receiver.receive()

        checkValidName(nameOfCars)
        checkValidNum(numOfGame)

        return Pair(nameOfCars!!, numOfGame!!.toInt())
    }

    private fun checkValidName(name: String?) {
        require(name.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }
    }

    private fun checkValidNum(num: String?) {
        require(num.isNullOrBlank()) { "입력값은 null 혹은 blank 값이 될 수 없습니다." }

        val numToInt: Int
        try {
            numToInt = num!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값 : $num, 정수형을 입력해 주세요.")
        }

        require(numToInt <= 0) { "입력값은 1 이상이어야만 합니다." }
    }
}
