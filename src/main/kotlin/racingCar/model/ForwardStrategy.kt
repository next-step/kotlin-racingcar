package racingCar.model

class ForwardStrategy : MoveStrategy {
    override fun move(mileage: Int) = mileage + MoveAmount.FORWARD_AMOUNT
}
