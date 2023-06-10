package step3

object RaceRule {
    private const val PROGRESS_NUMBER = 4

    fun isGo(number: RaceNumber): Boolean {
        return number.value >= PROGRESS_NUMBER
    }
}
