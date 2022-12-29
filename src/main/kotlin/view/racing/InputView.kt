package view.racing

class InputView private constructor() {
    companion object {
        fun carAmountInput(): Int {
            print("자동차 대수는 몇 대인가요?" + System.lineSeparator())
            return readln().toInt()
        }

        fun trialInput(): Int {
            print("시도할 횟수는 몇 회인가요?" + System.lineSeparator())
            return readln().toInt()
        }
    }
}
