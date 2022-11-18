package racingcar

class Statistics() {
    companion object {
        fun exec(cars: Cars): String {
            var result = ""
            var max = cars.findMaxStatusValue()

            cars.cars.forEach {
                car ->
                run {
                    if (car.isWinner(max)) {
                        result += car
                        result += ","
                    }
                }
            }
            return result
        }
    }
}
