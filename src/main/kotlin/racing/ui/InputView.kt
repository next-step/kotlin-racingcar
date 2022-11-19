package racing.ui

class InputView {

    companion object {

        fun requireCarsCount(): Int {
            println("자동차 대수는 몇 대인가요?")
            return inputNumber()
        }

        fun requireNumberOfGames(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return inputNumber()
        }

        private fun inputNumber() = readln().toInt()
    }
}
