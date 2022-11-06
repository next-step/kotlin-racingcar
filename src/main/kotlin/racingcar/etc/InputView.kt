package racingcar.etc

object InputView {

    fun numberOfCars(): String {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!
    }

    fun numberOfRaces(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!
    }
}
