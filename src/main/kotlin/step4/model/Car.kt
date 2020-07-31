package step4.model

data class Car(val name: String, var raceResult: Int, val raceHistory: MutableList<Int>) {
    fun save(resultOfTurn: Int) {
        raceResult += resultOfTurn
        raceHistory.add(resultOfTurn)
    }
}
