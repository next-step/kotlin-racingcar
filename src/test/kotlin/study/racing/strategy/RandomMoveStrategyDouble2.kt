package study.racing.strategy

import java.util.LinkedList
import java.util.Queue

class RandomMoveStrategyDouble2(
    movable: List<Boolean>
) : MoveStrategy {

    private val movableQueue: Queue<Boolean> = LinkedList(movable)

    override fun isMoving(): Boolean {
        return movableQueue.poll()
    }
}
