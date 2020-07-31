package racingcar

object InputView {
    fun readCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분, 이름은 5자를 넘길수없습니다.).")
        return checkCarName(inputCarName())
    }

    fun readMoveTime(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return checkMinus(inputInt())
    }

    private fun inputCarName(): List<String> {
        return readLine()!!.split(",")
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

    private fun checkCarName(carNameList: List<String>): List<String> {
        return carNameList.onEach {
            checkBlank(it)
            checkLengthFive(it)
        }
    }

    private fun checkBlank(str: String) {
        if (str.isBlank()) {
            throw Exception("공백을 입력하지 마세요")
        }
    }

    private fun checkLengthFive(str: String) {
        val carName = str.trim()
        if (carName.length > 5) {
            throw Exception("자동차 이름은 5글자 까지 가능합니다")
        }
    }
}
