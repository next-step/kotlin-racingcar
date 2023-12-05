package racing.domain

class FakeCarMoveLogic : CarMoveInterface {
    override fun isMoveList(carCnt: Int): List<Boolean> {
        return List(carCnt) { true }
    }
}
