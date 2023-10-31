package racing.moveprovider

import kotlin.random.Random

class MoveForwardProvider : MoveProvider {
    override fun getMove(): Int {
        return Random.nextInt(4, 10)
    }
}
