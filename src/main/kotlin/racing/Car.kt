package racing

class Car(val name: String) {
    private var turn = 0

    private val _turnOfPosition = arrayListOf(START_POSITION)
    val turnOfPosition: List<Int>
        get() = _turnOfPosition

    fun goIfAboveRequireGoValue(): Int {
        return if ((0..9).random() >= REQUIRE_GO_VALUE) GO else STAY
    }

    fun go(goIfAboveRequireGoValue: () -> Int) {
        _turnOfPosition.add(_turnOfPosition[turn++] + goIfAboveRequireGoValue())
    }

    override fun equals(other: Any?): Boolean {
        if (other is Car) {
            return other.name == this.name
        }

        return super.equals(other)
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        const val GO = 1
        const val STAY = 0

        const val REQUIRE_GO_VALUE = 4

        const val START_POSITION = 1
    }
}
