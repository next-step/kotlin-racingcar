package racingcar.view

class InputView {

    companion object {
        const val QUESTION_CAR_COUNT = "자동차 대수는 몇 대인가요?"
        const val TRY_CAR_RACING = "시도할 횟수는 몇 회인가요?"
    }

    fun inputCar(): Int {
        println(QUESTION_CAR_COUNT)
        return readLine()!!.toInt()
    }

    fun inputCount(): Int {
        println(TRY_CAR_RACING)
        return readLine()!!.toInt()
    }
}
