package step4

data class Car(val name: String, var raceResult: Int, val raceHistory: MutableList<Int>) {
    fun saveResult(resultOfTurn: Int) {
        raceResult += resultOfTurn
        raceHistory.add(resultOfTurn)
    }
}
