package racingcar.domain

class Statistics() {
    companion object {
        fun exec(cars: Cars): List<Car> {
            val max = cars.findMaxStatusValue()
            return cars.statistic(max)
        }
    }
}
