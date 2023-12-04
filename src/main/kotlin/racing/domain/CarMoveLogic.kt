package racing.domain

import kotlin.random.Random

class CarMoveLogic: CarMoveInterface {
    override fun isMoveList(carCnt: Int): List<Boolean> {
        return List(carCnt) { Random.nextInt(10) >= 5 }
    }
}
