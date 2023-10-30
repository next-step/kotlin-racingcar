package racing

object Validate {
    fun validateInputData(inputCarCnt: String, inputRacingCnt: String) {
        validateEmpty(inputCarCnt, inputRacingCnt)
        validateNumber(inputCarCnt, inputRacingCnt)
        validateZero(inputCarCnt, inputRacingCnt)
    }

    private fun validateEmpty(inputCarCnt: String, inputRacingCnt: String) {
        // 공백을 입력했을 경우
        if (inputCarCnt.isEmpty()) {
            throw IllegalArgumentException("출전할 자동차 대수를 입력해 주세요.")
        }
        if (inputRacingCnt.isEmpty()) {
            throw IllegalArgumentException("시도할 횟수를 입력해 주세요.")
        }
    }

    private fun validateNumber(inputCarCnt: String, inputRacingCnt: String) {
        // 숫자를 입력하지 않았을 경우
        if (inputCarCnt.toIntOrNull() == null) {
            throw NumberFormatException("출전할 자동차 대수를 잘못 입력하셨습니다.")
        }
        if (inputRacingCnt.toIntOrNull() == null) {
            throw NumberFormatException("시도할 횟수를 잘못 입력하셨습니다.")
        }
    }

    private fun validateZero(inputCarCnt: String, inputRacingCnt: String) {
        // 입력값에 0을 입력한 경우
        if (inputCarCnt.toInt() == 0) {
            throw IllegalArgumentException("출전할 자동차의 대수가 0 입니다.")
        }
        if (inputRacingCnt.toInt() == 0) {
            throw IllegalArgumentException("시도할 횟수가 0 입니다.")
        }
    }
}
