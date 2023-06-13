package racinggame.view

import java.util.LinkedList
import java.util.Queue

class MockRacingGameInputView : RacingGameInputView {

    private val queue: Queue<String> = LinkedList()

    fun setUp(vararg values: String) {
        clear()
        queue.addAll(values)
    }

    fun clear() {
        queue.clear()
    }
    override fun readLine(): String {
        return queue.poll()
    }
}
