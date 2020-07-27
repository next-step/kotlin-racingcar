import java.lang.NullPointerException

class CarRacingInputView {

    companion object {
        fun checkInput(input: String?): Int {
            if (input == null) {
                throw NullPointerException("값을 입력해주세요.")
            }
            if (input.isEmpty()) {
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
}
