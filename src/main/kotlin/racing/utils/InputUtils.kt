package racing.utils

class InputUtils {
    companion object {
        fun inputCarNum(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readln().toInt()
        }

        fun inputRound(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        }
    }
}
