package step3.domain.car

import step3.domain.game.formula.MoveFormula
import java.util.concurrent.atomic.AtomicInteger

class Car internal constructor(
    private val position: AtomicInteger = AtomicInteger(),
) {

    fun move(moveFormula: MoveFormula, value: Int): Int = if (moveFormula.move(value = value)) {
        position.incrementAndGet()
    } else {
        position.get()
    }

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        javaClass != other?.javaClass -> false
        position != (other as Car).position -> false
        else -> true
    }

    override fun hashCode(): Int {
        return position.hashCode()
    }
}
