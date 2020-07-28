import java.lang.NullPointerException
import java.lang.NumberFormatException

object CarRacingView {
    fun showFirstInstruction() {
        println(
            "STEP3 자동차 경주 \n\n" +
                "자동차 대수는 몇 대인가요? "
        )
    }

    fun showSecondInstruction() {
        println(
            "시도할 횟수는 몇 회인가요?"
        )
    }

    fun showMovement(count: Int) {
        for (i in 0..count) {
            print("-")
        }
        println("")
    }

    fun checkInput(input: String?): Int {
        if (input == null || input.isEmpty()) {
            throw NullPointerException("값을 입력해주세요.")
        }
        try {
            val number = input.toInt()
            if (number < 1) throw ArithmeticException("0 보다 큰 숫자를 입력해주세요")
            return number
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자를 입력해주세요.")
        }
    }
}
