package step3

class InputView {
    companion object {
        fun handleInput(): Pair<Int, Int> {
            val carCount = readCount("자동차 대수는 몇 대인가요?")
            val raceCount = readCount("시도할 횟수는 몇 회인가요?")

            return kotlin.Pair(carCount, raceCount)
        }

        private fun readCount(message: String): Int {
            var countString: String? = null

            while (countString.isNullOrBlank() || countString.toIntOrNull() == null) {
                println(message)
                countString = readLine()
            }

            return countString.toInt()
        }
    }
}
