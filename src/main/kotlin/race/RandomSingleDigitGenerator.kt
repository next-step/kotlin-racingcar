package race

object RandomSingleDigitGenerator : DigitGenerator {
    override operator fun invoke(): Int = (0..9).random()
}
