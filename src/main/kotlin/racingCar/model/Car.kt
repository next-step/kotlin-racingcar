package racingCar.model

data class Car(val mileage: Int = 0) {
    fun forward() = copy(mileage = this.mileage + 1)
}
