package step3.turn

interface Turn {
    var current: Int
    val doEachTurn: () -> Unit
    fun nextTurn() {
        doEachTurn()
        current++
    }
}
