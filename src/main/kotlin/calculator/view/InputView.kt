package calculator.view

class InputView {

    companion object {
        fun input(): String {
            print("문자열을 입력하세요.: ")
            val inputString = readLine()
            require(!inputString.isNullOrEmpty()) { "입력값은 빈문자열일 수 없습니다." }
            return inputString
        }
    }
}
