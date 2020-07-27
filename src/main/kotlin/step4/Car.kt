package step4

data class Car(val name: String, var raceResult: ArrayList<Int>) {
    fun saveResult(resultOfTurn: Int) {
        raceResult.add(resultOfTurn)
    }
}
