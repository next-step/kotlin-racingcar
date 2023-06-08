package step3

@JvmInline
value class RaceNumber private constructor(val value: Int) {
    init {
        require(value in 0..9)
    }

    companion object {
        fun from(number: Int): RaceNumber {
            return RaceNumber(number)
        }
    }
}
