package race.domain

object RandomSingleDigitGenerator : DigitGenerator {
    override operator fun invoke(): Int = (0..9).random()
}
