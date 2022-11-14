package step3

object RoundStore : Store<Round> {
    private var rounds = listOf<Round>()

    override fun findAll(): List<Round> {
        return this.rounds
    }

    override fun saveAll(list: List<Round>): List<Round> {
        this.rounds = list
        return this.rounds
    }
}
