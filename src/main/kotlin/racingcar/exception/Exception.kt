package racingcar.exception

class Exception {
    companion object {
        const val CASE_ZERO_WINNER = "우승자가 단 한명도 없습니다."
        const val CASE_ZERO_RACING_ROUND = "경주는 1회 이상 진행되어야 게임을 시작할 수 있습니다."
        const val CASE_INCORRECT_FORMAT_NAME_OF_CAR = "차 이름 형식에 옳바르지 않습니다."
        const val CASE_INPUT_DATA_NOT_INT = "숫자만 입력해주셔야 합니다."
        const val CASE_INPUT_DATA_WRONG = "1 이상의 값을 입력주새셔야 게임을 진행할 수 있습니다."
    }
}
