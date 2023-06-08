package step3.domain.car

import step3.domain.formula.MoveFormula
import step3.model.RaceConst
import java.util.concurrent.atomic.AtomicInteger

object CarFactory {

    private const val DEFAULT_POSITION = 0

    fun createCar(position: Int = DEFAULT_POSITION, moveFormula: MoveFormula): Car = Car(
        position = AtomicInteger(position),
        moveFormula = moveFormula,
    )

    @OptIn(ExperimentalStdlibApi::class)
    fun createCars(
        count: Int,
        position: Int = DEFAULT_POSITION,
        moveFormula: MoveFormula,
    ): List<Car> = RaceConst.ZERO
        .rangeUntil(other = count)
        .map { createCar(position = position, moveFormula = moveFormula) }
}
