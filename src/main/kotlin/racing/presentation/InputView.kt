package racing.presentation

class InputView {
    fun inputAttempt(): String {
        println("이동 횟수를 입력하세요")

        var string = readLine()

        while (!validateAttempt(string)) {
            println("다시 입력해주세요")
            string = readLine()
        }
        return string!!
    }

    fun inputNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        var string = readLine()

        while (!validateNames(string)) {
            println("다시 입력해주세요")
            string = readLine()
        }
        return string!!
    }

    fun validateAttempt(attempt: String?): Boolean {
        if (attempt.isNullOrBlank()) {
            println(DATA_IS_BLANK)
            return false
        }
        if (NON_NUMERIC_REGEX.matches(attempt)) {
            println(IS_POSSIBLE_NUMERIC)
            return false
        }
        return true
    }

    fun validateNames(names: String?): Boolean {
        if (names.isNullOrBlank()) {
            println(DATA_FORMAT_IS_BAD)
            return false
        }
        if (splitNames(names).isNullOrEmpty()) {
            println(DATA_FORMAT_IS_BAD)
            return false
        }
        splitNames(names).map {
            if (it.length > 5) {
                println(EXCEED_FIVE_CHARACTERS)
                return false
            }
        }
        return true
    }

    fun splitNames(names: String) =
        names
            .split(DELIMITER)
            .filter { name -> name.isNotBlank() }
            .map { name -> name.trim() }

    companion object {
        val NON_NUMERIC_REGEX = Regex("[^0-9]")
        const val DELIMITER = ","
        const val DATA_IS_BLANK = "값이 비어있습니다"
        const val IS_POSSIBLE_NUMERIC = "숫자만 입력 가능합니다"
        const val DATA_FORMAT_IS_BAD = "데이터 입력 포멧이 이상합니다"
        const val EXCEED_FIVE_CHARACTERS = "자동차 이름은 5자를 초과 할 수 없습니다"
    }
}
