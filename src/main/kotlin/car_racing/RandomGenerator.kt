package car_racing

import java.util.Random

object RandomGenerator {

    private val random = Random()

    fun value(): Int = random.nextInt(10)
}
