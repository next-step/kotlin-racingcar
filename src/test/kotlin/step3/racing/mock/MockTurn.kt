package step3.racing.mock

import step3.turn.Turn

class MockTurn : Turn {
    override var current = 0
    override val doEachTurn = {}
}
