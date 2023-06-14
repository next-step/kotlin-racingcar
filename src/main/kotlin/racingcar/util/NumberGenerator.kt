package racingcar.util

interface NumberGenerator {
    fun getNumber(): Int

    companion object {
        const val MIN_GENERATED_NUMBER = 0
        const val MAX_GENERATED_NUMBER = 9
    }
}
