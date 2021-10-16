package view

/**
 * 자동차 경주에서 게임 시작시 사용자가 입력해야하는 질문 모음 class
 * */
class InputView {
    fun requestNumberOfCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toInt()
    }

    fun requestTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
