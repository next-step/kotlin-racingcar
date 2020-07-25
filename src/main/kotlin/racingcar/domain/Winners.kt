package racingcar.domain

class Winners(private val winners: List<Car>) {
    fun joinWinnersName(): String {
        return winners.joinToString { it.name }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}
