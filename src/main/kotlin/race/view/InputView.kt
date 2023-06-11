package race.view

class InputView {
    fun input(): InputData {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCar = readln().toInt()

        println("시도할 횟수는 몇 회인가요?")
        val numberOfTry = readln().toInt()

        return InputData(numberOfCar, numberOfTry)
    }
}
