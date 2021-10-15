package racingcar.view

class InputView {

    companion object {
        fun inputCars(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readLine()!!.toInt()
        }
    }
}
