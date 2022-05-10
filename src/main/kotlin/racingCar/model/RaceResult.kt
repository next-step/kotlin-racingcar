package racingCar.model

/**
 * 레이스 결과를 저장하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RaceResult(carList: List<Car>) {
    var resultOutput = StringBuilder()
        private set

    init {
        carList.forEach {
            repeat(it.position) {
                resultOutput.append(RACE_FOOTPRINT_SYMBOL)
            }
            resultOutput.append("\n")
        }
    }

    companion object {
        private const val RACE_FOOTPRINT_SYMBOL = "-"
    }
}
