package racing_car.view

object InputView {

    fun inputNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun inputRacingRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
