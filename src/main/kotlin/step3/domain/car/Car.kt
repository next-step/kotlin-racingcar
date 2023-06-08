package step3.domain.car

import step3.domain.formula.MoveFormula
import java.util.concurrent.atomic.AtomicInteger

class Car internal constructor(
    val name: String,
    private val position: AtomicInteger = AtomicInteger(),
) {

    fun move(moveFormula: MoveFormula): Int = if (moveFormula.move()) {
        position.incrementAndGet()
    } else {
        position.get()
    }

    fun currentPosition(): Int = position.get()

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
