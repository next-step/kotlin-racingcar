package step3

class RaceRule {
    companion object {
        private const val PROGRESS_NUMBER = 4
    }

    fun isGo(number: RaceNumber): Boolean {
        return number.value == PROGRESS_NUMBER
    }
}
