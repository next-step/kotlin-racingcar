package racing.io

object Input {

    private const val READ_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val READ_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun readCarNames(): String {
        println(READ_CAR_MESSAGE)
        return readln()
    }

    fun readTryCount(): Int {
        println(READ_TRY_MESSAGE)
        return readln().toInt()
    }
}
