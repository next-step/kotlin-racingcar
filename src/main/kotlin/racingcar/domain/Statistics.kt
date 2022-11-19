package racingcar.domain

class Statistics() {
    companion object {
        fun exec(cars: Cars): List<Car> {
            var max = cars.findMaxStatusValue()
            return cars.statistic(max)
        }
    }
}
