package racingcar

class Cars(var cars: List<Car>) {
    fun move(): String {
        var result = ""
        cars.forEach {
            it.move((RANDOM_NUMBER_RANGE).random())
            result += it.makeResult()
        }
        return result
    }

    fun findMaxStatusValue(): Int {
        var max = Int.MIN_VALUE
        for (car in cars) {
            if (car.status > max) {
                max = car.status
            }
        }
        return max
    }

    companion object {
        val RANDOM_NUMBER_RANGE = 0..9
    }
}
