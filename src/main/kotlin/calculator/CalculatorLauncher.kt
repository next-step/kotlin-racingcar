package calculator

class CalculatorLauncher {
    companion object {
        const val EXIT_KEY = "x"

        @JvmStatic
        fun main(args: Array<String>) {
            var inputExpression = receiveInputExpression()

            while (!EXIT_KEY.equals(inputExpression, true)) {
                println("결과: " + Calculator.calculate(inputExpression).value)
                inputExpression = receiveInputExpression()
            }
        }

        private fun receiveInputExpression(): String? {
            println("계산할 수식을 입력하세요.(x키는 종료)")
            return readLine()
        }
    }
}
