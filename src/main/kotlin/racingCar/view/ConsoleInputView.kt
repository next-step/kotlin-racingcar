package racingCar.view

class ConsoleInputView : InputView {
    override fun getCarNames(): List<String> {
        print("자동차 이름들을 입력해주세요. (,로 구분)")
        return readln().split(",")
    }

    override fun getRoundCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
