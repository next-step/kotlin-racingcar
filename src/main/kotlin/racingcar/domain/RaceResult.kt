package racingcar.domain

/**
 * 레이스 결과를 저장하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RaceResult(carList: List<Car>) {
    var resultOutput: String
        private set
    val winners: List<String> = run {
        val positionOfFastest = carList.maxOf { it.position }
        carList.filter { it.position == positionOfFastest }.map { it.name }
    }

    init {
        val result = StringBuilder()
        carList.forEach {
            result.append(it.name + " : ")
            result.append(RACE_FOOTPRINT_SYMBOL.repeat(it.position))
            result.appendLine()
        }
        resultOutput = result.toString()
    }

    companion object {
        private const val RACE_FOOTPRINT_SYMBOL = "-"
    }
}
