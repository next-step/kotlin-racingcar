package raicing

object Const {
    object OutputMsg {
        const val CAR_NAME_MSG = "경주할 자동차의 이름을 입력해주세요. (','로 구분하며, 이름은 5자를 초과할 수 없습니다.)"
        const val RACE_COUNT_MGS = "시도할 횟수는 몇 회인가요?"
    }

    object ErrorMsg {
        const val INPUT_IS_EMPTY_ERROR_MSG = "값이 비어있습니다."
        const val INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG = "자연수만 입력 가능합니다."
        const val CAR_NAME_IS_TOO_LONG = "자동차 이름이 너무 깁니다. 5자를 초과할 수 없습니다."
    }
}
