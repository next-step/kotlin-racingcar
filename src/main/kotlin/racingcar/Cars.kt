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

    companion object {
        val RANDOM_NUMBER_RANGE = 0..9
    }
}
