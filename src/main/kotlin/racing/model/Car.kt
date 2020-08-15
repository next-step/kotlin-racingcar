package racing.model

data class Car(val name: String, val raceHistory: MutableList<Int> = mutableListOf()) {
    fun saveResultOfTurn(resultOfTurn: Int) {
        raceHistory.add(resultOfTurn)
    }

    fun takeRaceHistory(numberOfTrials: Int): Int {
        return raceHistory.take(numberOfTrials).sum()
    }

    fun isIn(position: Int) = this.raceHistory.sum() == position
}
