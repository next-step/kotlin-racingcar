package next.step.racing.service.to

data class StepCount(val cnt: Int) {

    companion object {
        fun from(str: String): StepCount {
            require(str.isNotBlank()) { "공백이 아니어야 합니다." }
            require(str.isNumeric()) { "숫자가 입력되야 합니다." }
            require(isPositive(str.toInt())) { "0보다 큰 숫자여야 합니다." }
            return StepCount(str.toInt())
        }

        private fun isPositive(cnt: Int): Boolean = cnt > 0
    }
}

private fun String.isNumeric(): Boolean =
    this.all { char -> char.isDigit() } || (this.startsWith("-") && this.substring(1).all { char -> char.isDigit() })
