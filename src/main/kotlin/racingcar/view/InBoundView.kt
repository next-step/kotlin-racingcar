package racingcar.view

class InBoundView(
    private val readLine: () -> String,
    private val print: (String) -> Unit
) {
    fun requestCarNames(): List<String> {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n")
        val names: String = readLine()
        require(names.isNotBlank()) {
            "경주할 자동차 이름이 입력 되지 않았습니다."
        }

        return names.split()
    }

    fun requestNumberOfMove(): Int {
        print("시도할 횟수는 몇 회인가요?: ")
        return readText()
    }

    private fun readText(): Int {
        val number: String = readLine()
        return runCatching { number.toInt() }
            .getOrElse { throw IllegalArgumentException() }
    }

    private fun String.split(): List<String> {
        return this.split(",").checkDriverNames()
    }

    private fun List<String>.checkDriverNames(): List<String> {
        this.forEach { name ->
            run {
                val removedWhiteSpaceName = name.trim()

                require(removedWhiteSpaceName.isNotBlank()) {
                    "공백을 입력할 수 없습니다."
                }

                require(removedWhiteSpaceName.length <= MAX_CAR_NAME_LENGTH) {
                    "이름은 5글자가 넘을 수 없습니다."
                }
            }
        }

        return this
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
