package racing

class Car(val name: String) {
    private var turn = 0

    val turnOfPosition = arrayListOf(1)

    fun go() {
        turnOfPosition.add(turnOfPosition[turn++] + if ((0..9).random() >= REQUIRE_GO_VALUE) GO else STAY)
    }

    companion object {
        const val GO = 1
        const val STAY = 0

        const val REQUIRE_GO_VALUE = 4
    }
}
