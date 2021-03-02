package step3

class InputView {
    companion object {
        fun handleInput(): Pair<String, Int> {
            val carNames = readNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            val lapCount = readCount("시도할 횟수는 몇 회인가요?")

            return Pair(carNames, lapCount)
        }

        private fun readNames(message: String): String {
            var names: String? = null

            while (names.isNullOrBlank()) {
                println(message)
                names = readLine()
            }

            return names
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
