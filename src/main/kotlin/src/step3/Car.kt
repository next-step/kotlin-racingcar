package src.step3

class Car(
    var moveCounts: MutableList<Int> = mutableListOf(),
) {

    fun move(moveCount: Int) {
        moveCounts.add(moveCount)
    }
}
