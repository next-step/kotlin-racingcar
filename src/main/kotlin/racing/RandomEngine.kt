package racing

import kotlin.random.Random
import kotlin.random.nextInt

object RandomEngine : Engine {

    private val random = Random.Default

    override fun canMove(): Boolean {
        return random.nextInt(0..9) >= 4
    }
}
