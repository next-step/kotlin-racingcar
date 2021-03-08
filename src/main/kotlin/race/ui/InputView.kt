package race.ui

class InputView {
    companion object {
        fun inputCarCount(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readLine()!!.toInt()
        }

        fun inputRaceCount(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readLine()!!.toInt()
        }
    }
}
