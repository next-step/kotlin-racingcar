package calculator

object ConsoleInputView {

    fun getExpression(): String {
        println("식을 입력해주세요")
        return readLine() ?: throw IllegalArgumentException("null은 입력으로 허용되지 않습니다")
    }
}
