package racingCar.model

/**
 * 레이스 결과를 저장하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RaceResult(carList: List<Car>) {
    var resultOutput: String? = null
        private set

    init {
        val result = StringBuilder()
        carList.forEach {
            result.append(it.name + " : ")
            result.append(RACE_FOOTPRINT_SYMBOL.repeat(it.position))
            result.append("\n")
        }
        resultOutput = result.toString()
    }

    companion object {
        private const val RACE_FOOTPRINT_SYMBOL = "-"
    }
}
