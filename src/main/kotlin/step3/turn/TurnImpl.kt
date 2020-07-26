package step3.turn

class TurnImpl(override val doEachTurn: () -> Unit) : Turn {
    override var current = 0
}
