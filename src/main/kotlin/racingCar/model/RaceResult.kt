package racingCar.model

/**
 * 클래스에 대한 설명을 적어주세요.
 * Created by Jaesungchi on 2022.05.07..
 */
class RaceResult {
    var resultOutput = StringBuilder()
        private set

    fun saveCarResult(carList: List<Car>) {
        carList.forEach {
            repeat(it.position) {
                resultOutput.append("-")
            }
            resultOutput.append("\n")
        }
    }
}