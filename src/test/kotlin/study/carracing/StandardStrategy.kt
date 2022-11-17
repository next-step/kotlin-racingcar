package study.carracing

import carracing.domain.MoveStrategy

class StandardStrategy(private val number: Int) : MoveStrategy {

    override fun isMovable(): Boolean {
        return number >= 4
    }
}
