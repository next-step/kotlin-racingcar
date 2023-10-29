package calculator

class Checker {
    companion object {
        fun checkInput(input: String?) {
            if (input == null || input == "") {
                throw IllegalArgumentException("입력값이 없습니다!!")
            }
        }
    }
}
