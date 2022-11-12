package study.step4.model

private const val ADVANCE_BASE_DIGIT = 4

class DigitEngine(
    private val digitGenerator: DigitGenerator
) : EnginGenerator {
    override fun run(): Boolean = digitGenerator.getDigit() >= ADVANCE_BASE_DIGIT
}