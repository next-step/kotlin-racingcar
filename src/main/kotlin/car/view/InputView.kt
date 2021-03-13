package car.view

class InputView {
    fun input(): Input {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val name = readLine()!!

        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()!!.toInt()

        return Input(name, tryCount)
    }
}
