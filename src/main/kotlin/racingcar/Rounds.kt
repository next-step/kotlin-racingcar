package racingcar

class Rounds(private val rounds: List<Round>) {
    fun forEach(action: (Round) -> Unit) {
        rounds.forEach(action)
    }

    fun getByIndex(index: Int): Round {
        return rounds[index]
    }

    fun getSize(): Int {
        return rounds.size
    }
}
