package racing.ui

class InputView {

    companion object {
        private const val SEPARATOR = ","

        fun requireRacingCarNames(): Array<String> {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분")
            val readString = readString()
            return readString.split(SEPARATOR).toTypedArray()
        }

        fun requireNumberOfGames(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readNum()
        }

        private fun readNum() = readln().toInt()

        private fun readString() = readln()
    }
}
