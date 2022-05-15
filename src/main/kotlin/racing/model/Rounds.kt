package racing.model

class Rounds() {
    val roundMap = mutableMapOf<Int, Round>()

    fun put(roundNo: Int, round: Round) {
        roundMap[roundNo] = round
    }

    fun get(roundNo: Int): Round? {
        return roundMap[roundNo]
    }
}