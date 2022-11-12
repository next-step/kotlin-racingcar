package racingcar

class Statistics() {
    companion object {
        fun exec(cars: List<Car>): String {
            var max = Int.MIN_VALUE
            for (car in cars) {
                if (car.status > max) {
                    max = car.status
                }
            }

            var result: StringBuilder = StringBuilder()
            for (i in cars.indices) {
                if (cars[i].status == max) {
                    result.append(cars[i].name)
                    if (i != cars.size - 1) {
                        result.append(", ")
                    }
                }
            }
            result.append("가 최종 우승했습니다.")
            return result.toString()
        }
    }
}
