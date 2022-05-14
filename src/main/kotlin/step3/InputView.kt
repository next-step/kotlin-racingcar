package step3

object InputView {
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
        if (str?.toIntOrNull() == null) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
            return readInt()
        }
        return str.toInt()
    }
}
