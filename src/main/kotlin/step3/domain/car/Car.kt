package step3.domain.car

import step3.domain.game.formula.MoveFormula
import java.util.concurrent.atomic.AtomicInteger

data class Car internal constructor(
    private val position: AtomicInteger = AtomicInteger(),
) {

    fun move(moveFormula: MoveFormula, value: Int): Int = if (moveFormula.move(value = value)) {
        position.incrementAndGet()
    } else {
        position.get()
    }
}
