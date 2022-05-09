package car_racing

import java.util.Random

object RandomGenerator {
    private const val BOUNDARY_INT = 10

    private val random = Random()

    fun value(): Int = random.nextInt(BOUNDARY_INT)
}
