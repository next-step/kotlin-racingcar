package racingcar

class ResultView {
    fun printResult(result: String) {
        if (result.last() == ',') {
            print(result.substring(0, result.lastIndex))
        }
        if (result.last() != ',') {
            print(result)
        }
        println("가 최종 우승했습니다.")
    }

    fun makeResults(cars: List<Car>): String {
        var result = ""
        for (m in cars) {
            val makeResult = this.makeResult(m)
            result += makeResult
        }
        return result
    }

    fun makeResult(car: Car): String {
        val str: StringBuilder = StringBuilder()
        str.append(car.name + " : ")
        for (i in 1..car.status) {
            str.append("-")
        }
        str.append("\n")
        return str.toString()
    }
}
