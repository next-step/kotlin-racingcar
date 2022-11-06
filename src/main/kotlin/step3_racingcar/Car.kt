package step3_racingcar

data class Car(
    private val distance: List<Char> = emptyList()
) {
    companion object {
        @JvmStatic
        private fun move() {}
    }
}
