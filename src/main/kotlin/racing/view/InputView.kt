package racing.view

object InputView {
    // 자동차 이름
    fun inputCarName(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputData = readln()
        validateCarNameInputData(inputData)
        return inputData
    }

    // 레이싱 횟수
    fun inputRacingPlayCnt(): String {
        println("시도할 횟수는 몇 회인가요?")
        val inputData = readln()
        validateRacingCntInputData(inputData)
        return inputData
    }

    private fun validateCarNameInputData(inputData: String) {
        validateZeroCarCnt(inputData)
    }

    private fun validateRacingCntInputData(inputData: String) {
        validateEmpty(inputData)
        validateNumber(inputData)
        validateZero(inputData)
    }

    //
    private fun validateZeroCarCnt(inputData: String) {
        val nameList = inputData.split(',')
            .map { it.trim() }
            .filter { it.isNotBlank() }

        if (nameList.isEmpty()) {
            throw IllegalArgumentException("출전할 자동차의 대수가 0 입니다.")
        }
    }

    // 레이싱 횟수
    private fun validateEmpty(inputData: String) {
        if (inputData.isEmpty()) {
            throw IllegalArgumentException("시도할 횟수를 입력해 주세요.")
        }
    }

    private fun validateNumber(inputData: String) {
        // 숫자를 입력하지 않았을 경우
        if (inputData.toIntOrNull() == null) {
            throw NumberFormatException("시도할 횟수를 잘못 입력하셨습니다.")
        }
    }

    private fun validateZero(inputData: String) {
        // 입력값에 0을 입력한 경우
        if (inputData.toInt() == 0) {
            throw IllegalArgumentException("시도할 횟수가 0 입니다.")
        }
    }
}
