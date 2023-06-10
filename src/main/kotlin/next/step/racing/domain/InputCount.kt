package next.step.racing.domain

data class InputCount(val cnt: Int) {
    companion object {
        fun from(str: String): InputCount {
            require(str.isNotBlank() && str.isNumeric() && isPositive(str.toInt())) { "잘못된 형식의 숫자입니다." }
            return InputCount(str.toInt())
        }

        private fun isPositive(cnt: Int): Boolean = cnt > 0
    }
}

private fun String.isNumeric(): Boolean = this.all { char -> char.isDigit() }
