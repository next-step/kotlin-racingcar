package racingCar.model

class ForwardStrategy : MoveStrategy, MoveAmount() {
    override fun move(mileage: Int) = mileage + moveAmount
}
