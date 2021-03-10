package racingcar.util

@Suppress("SpellCheckingInspection")
class Message {
    companion object {
        const val NOTICE_INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?"
        const val NOTICE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
        const val NOTICE_OUTPUT_WINNERS = "가 최종 우승했습니다."
        const val NOTICE_RESULT = "실행 결과"
        const val ONE_DISTANCE = "-"
        const val NOTICE_CANNOT_CAST_TO_INT = "을(를) Int형으로 변환할 수 없습니다."
        const val NOTICE_NOT_NULL = "문자열은 null이 될 수 없습니다."
        const val NOTICE_NOT_BLANK = "문자열은 공백이 될 수 없습니다."
        const val DEFAULT_DISTANCE = 0
        const val MAX_CONDITION = 10
        const val MIN_CONDITION = 0
        const val DELIMITERS_COMMA = ","
        const val SEPARATOR_OUTPUT_WINNERS = ", "
        const val MIN_CONDITION_FOR_GOING = 4
        const val MAX_LENGTH_NAME = 5
        const val NOTICE_NOT_MAXLENGTH_NAME = "자동차 이름은 ${MAX_LENGTH_NAME}자를 초과할 수 없습니다."
    }
}
