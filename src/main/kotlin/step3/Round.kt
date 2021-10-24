package step3

data class Round(private val roundNumber: Int = DEFAULT_NUMBER_OF_ROUND) {
    val number = roundNumber
}

const val DEFAULT_NUMBER_OF_ROUND = 0
