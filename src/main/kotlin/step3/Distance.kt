package step3

data class Distance(val default: Int = 0) {
    fun calculate() = (0..9).random()
}
