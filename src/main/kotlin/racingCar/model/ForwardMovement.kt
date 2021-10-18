package racingCar.model

class ForwardMovement : MoveAmount() {
    fun forward(mileage: Int) = mileage + moveAmount
}
