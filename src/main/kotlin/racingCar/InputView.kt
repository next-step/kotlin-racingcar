package racingCar

object InputView {

    fun getCarCount(): Int? {
        println("경주에 참여할 자동차의 수는?")
        return readLine()?.toInt()
    }

    fun getTrialCount(): Int? {
        println("경주를 시도할 횟수는?")
        return readLine()?.toInt()
    }
}
