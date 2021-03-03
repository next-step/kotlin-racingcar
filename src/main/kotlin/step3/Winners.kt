package step3

class Winners(val winners: List<Record>) {
    override fun toString(): String {
        return winners.joinToString { it.name }
    }
}
