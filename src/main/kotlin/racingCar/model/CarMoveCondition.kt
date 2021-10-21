package racingCar.model

class CarMoveCondition(private val move: Int) : MoveCondition {
    override fun isValid() = move >= 4
}
