package carracing

import kotlin.random.Random

object RandomNumberGenerator {
     fun getRandom() = Random.nextInt(RANDOM_NUMBER_BOUNDARY)


    private const val RANDOM_NUMBER_BOUNDARY = 10

}
