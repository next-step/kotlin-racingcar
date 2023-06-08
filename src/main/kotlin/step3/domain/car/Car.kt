package step3.domain.car

import step3.domain.formula.MoveFormula
import java.util.concurrent.atomic.AtomicInteger

data class Car internal constructor(
    private val position: AtomicInteger = AtomicInteger(),
    private val moveFormula: MoveFormula,
) {

    fun move(value: Int): Int = if (moveFormula.move(value = value)) {
        position.incrementAndGet()
    } else {
        position.get()
    }
}
