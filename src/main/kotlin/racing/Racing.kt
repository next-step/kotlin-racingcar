package racing

import java.util.function.Consumer

internal class Racing(
    private val cars: List<Car>,
    private val movable: Movable
) {
    val positions: List<Int>
        get() = this.cars.map { it.position }

    fun tryMove() {
        this.cars.forEach(Consumer { it.tryMove(movable) })
    }
}
