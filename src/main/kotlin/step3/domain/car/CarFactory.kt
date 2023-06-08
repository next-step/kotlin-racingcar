package step3.domain.car

import step3.domain.formula.MoveFormula
import java.util.concurrent.atomic.AtomicInteger

object CarFactory {

    private const val DEFAULT_POSITION = 0

    fun createCar(position: Int = DEFAULT_POSITION, moveFormula: MoveFormula): Car = Car(
        position = AtomicInteger(position),
        moveFormula = moveFormula,
    )
}
