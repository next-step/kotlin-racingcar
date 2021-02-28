package calculator.util

@Suppress("SpellCheckingInspection")
class Const {
    companion object {
        const val NOTICE_INPUT = "사칙연산 문자열을 입력해주세요 (띄어쓰기로 구분)"
        const val NOTICE_NOT_NULL = "문자열은 null이 될 수 없습니다."
        const val NOTICE_NOT_BLANK = "문자열은 공백이 될 수 없습니다."
        const val NOTICE_NOT_OPERATOR_SYMBOL = "에 해당하는 연산은 존재하지 않습니다."
        const val NOTICE_NOT_OPERAND_SYMBOL = "를 double형으로 변환할 수 없습니다."
        const val NOTICE_NOT_DIVIDE_ZERO = "0으로는 나눌 수 없습니다."
        const val DELIMITERS_BLANK = " "
    }
}
