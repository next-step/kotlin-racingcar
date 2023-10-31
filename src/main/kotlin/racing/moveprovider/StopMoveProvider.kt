package racing.moveprovider

import kotlin.random.Random

class StopMoveProvider : MoveProvider {
    override fun getMove(): Int {
        return Random.nextInt(4)
    }
}
