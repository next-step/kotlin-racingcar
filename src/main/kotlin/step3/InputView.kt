package step3

class InputView {
    companion object {
        fun getNumCars(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readInt()
        }

        fun getNumTries(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readInt()
        }

        fun readInt(): Int {
            val str = readLine()
            if (str.isNullOrEmpty() || !str.all { it.isDigit() }) {
                println("잘못된 입력입니다. 다시 입력해주세요.")
                return readInt()
            }
            return str.toInt()
        }
    }
}
