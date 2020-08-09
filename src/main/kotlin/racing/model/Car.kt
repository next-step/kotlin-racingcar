package racing.model

data class Car(val name: String, private val raceHistory: MutableList<Int>) {
    fun saveResultOfTurn(resultOfTurn: Int) {
        raceHistory.add(resultOfTurn)
    }

    fun takeRaceHistory(numberOfTrials: Int): Int {
        return raceHistory.take(numberOfTrials).sum()
    }

    fun isIn(position: Int) = this.raceHistory.sum() == position
}
