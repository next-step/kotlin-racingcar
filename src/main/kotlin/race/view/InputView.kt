package race.view

object InputView {
    fun inputNumberOfCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    fun inputNumberOfRace(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
