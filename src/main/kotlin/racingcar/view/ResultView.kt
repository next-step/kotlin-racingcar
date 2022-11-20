package racingcar.view

import racingcar.domain.Car

class ResultView {
    fun printResult(cars: List<Car>, result: String) {
        print(result)

        cars.forEachIndexed() {
            index, _ ->
            print(cars[index].name)
            if (cars.lastIndex != index) {
                print(",")
            }
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

    private fun makeResult(car: Car): String {
        val str: StringBuilder = StringBuilder()
        str.append(car.name + " : ")
        for (i in 1..car.status) {
            str.append("-")
        }
        str.append("\n")
        return str.toString()
    }
}
