package racing

class Car(val name: String) {
    private var turn = 0

    val turnOfPosition = arrayListOf(1)

    fun go() {
        turnOfPosition.add(turnOfPosition[turn++] + if ((0..9).random() >= 4) 1 else 0)
    }
}
