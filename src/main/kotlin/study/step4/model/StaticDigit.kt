package study.step4.model

class StaticDigit(private val digit: Int) : DigitGenerator {
    override fun getDigit() = digit
}
