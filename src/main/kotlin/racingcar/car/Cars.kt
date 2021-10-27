package racingcar.car

class Cars(carCount: Int) {
    private val carList: List<Car> = CarFactory.initCarList(carCount)

    fun getCarList(): List<Car> {
        return carList
    }

    fun getRacingResult(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }
}
