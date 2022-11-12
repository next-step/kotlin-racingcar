package racingcar

class Cars(var cars: List<Car>) {
    init {
        this.cars = cars

        // for (carName in carNames) {
        //     if (carName.length > InputView.NAME_LENGTH_CONDITION)
        //         throw IllegalArgumentException("자동자 이름은 ${InputView.NAME_LENGTH_CONDITION}자를 넘을 수 없습니다.")
        // }
    }
}