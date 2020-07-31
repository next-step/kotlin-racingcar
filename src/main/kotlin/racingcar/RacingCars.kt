package racingcar

class RacingCars {
    val carList: List<RacingCar>

    constructor(carNameList: List<String>) {
        carList = carNameList.map { RacingCar(it) }
    }
}
