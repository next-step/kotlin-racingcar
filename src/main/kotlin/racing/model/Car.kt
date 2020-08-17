package racing.model

class Car(val name: String, raceHistory: List<Int> = emptyList()) {
    private val _raceHistory: MutableList<Int> = raceHistory.toMutableList()
    val raceHistory: List<Int>
        get() {
            return _raceHistory.toMutableList()
        }

    fun saveResultOfTurn(resultOfTurn: Int) {
        _raceHistory.add(resultOfTurn)
    }

    fun takeRaceHistory(numberOfTrials: Int): Int {
        return _raceHistory.take(numberOfTrials).sum()
    }

    fun isIn(position: Int) = this._raceHistory.sum() == position
}
