package step3

@JvmInline
value class RaceNumber private constructor(val value: Int) {
    init {
        require(value in RANDOM_RANGE)
    }

    companion object {
        private val RANDOM_RANGE = 0..9

        fun from(number: Int): RaceNumber {
            return RaceNumber(number)
        }

        fun generateRandomNumber(): Int {
            return (RANDOM_RANGE).random()
        }
    }
}
