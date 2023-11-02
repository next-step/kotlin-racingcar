package racing.moveprovider

import kotlin.random.Random

class RandomMoveProvider : MoveProvider {
    override fun getMove(): Int {
        return Random.nextInt(10)
    }
}
