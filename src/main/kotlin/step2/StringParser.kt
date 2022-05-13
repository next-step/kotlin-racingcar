package step2

class StringParser {
    companion object {
        const val emptyMessage = "입력값이 없습니다."
        const val errorMessage = "입력값이 잘못되었습니다."
        fun parse(string: String): List<String> {
            if (string.isBlank()) {
                throw IllegalArgumentException(emptyMessage)
            }
            val res = string.split("").joinToString("") {
                if (it == "" || it == " ") {
                    ""
                } else if (Operators.list.contains(it)) {
                    " $it "
                } else if (it.matches("[\\d|.]".toRegex())) {
                    it
                } else {
                    throw IllegalArgumentException("$errorMessage [$it]")
                }
            }.split(" ")

            return res
        }
    }
}
