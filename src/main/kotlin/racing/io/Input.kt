package racing.io

object Input {

    private const val READ_CAR_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val READ_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun readCarCount(): Int {
        println(READ_CAR_MESSAGE)
        return readln().toInt()
    }

    fun readTryCount(): Int {
        println(READ_TRY_MESSAGE)
        return readln().toInt()
    }
}
