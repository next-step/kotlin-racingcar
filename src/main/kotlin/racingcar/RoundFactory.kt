package racingcar

object RoundFactory {
    fun createMany(amount: Int): List<Round> {
        return (1..amount).map { index ->
            Round(id = index)
        }
    }
}
