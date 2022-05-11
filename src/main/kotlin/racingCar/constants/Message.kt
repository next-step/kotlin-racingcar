package racingCar.constants

/**
 * 출력만 되는 메세지들을 모아둔 Object class
 * Created by Jaesungchi on 2022.05.07..
 */
object Message {
    // 사용자에게 일반적으로 출력되는 메세지
    object PrintingMessage {
        const val PLEASE_WRITE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val HOW_MANY_TIMES_RACE = "시도할 횟수는 몇 회인가요?"
        const val EXECUTION_RESULT = "실행 결과"
    }

    // 예외 메세지
    object ExceptionMessage {
        const val IS_NULL_OR_BLANK = "입력된 숫자가 null이거나 비어있습니다."
        const val IS_NOT_INTEGER = "정수로 바꿀수 없는 숫자가 입력되었습니다."
        const val ENTERED_INVALID_NUMBER = "계산할 수 없는 숫자가 입력되었습니다."
        const val CANNOT_NAME_EXCEED_5_CHARACTERS = "이름은 5글자를 초과할 수 없습니다."
        const val CANNOT_NAME_BE_BLANK = "이름은 빈칸일 수 없습니다."
    }
}
