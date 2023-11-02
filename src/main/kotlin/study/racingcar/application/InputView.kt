package study.racingcar.application

/**
 * 값을 입력 받는다.
 * */
data class InputValue(val carNames: List<CarName>, val tryCount: Int)

class InputView(
    val reader: Reader) {

    /**
     * stdin 으로 입력을 받고, 입력받은 값을 검증해서 InputValue 로 반환한다.
     * @param 입력을 받는 Reader 객체
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun getInput(): InputValue {
        val carNames: List<CarName> = inputString("자동차 이름을 입력하세요: ")
        val tryCount: Int = inputNumber("시도할 횟수를 입력하세요: ")

        val inputValue = InputValue(carNames, tryCount)

        return inputValue
    }

    /**
     * 자동차 이름의 문자열 배열을 입력받는다.
     * @param prompt N 개의 자동차 이름 문자열을 유도하는 문자열
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 문자열이 아닌 경우
     * */
    fun inputString(prompt: String) : List<CarName>{
        while (true) {
            try {
                print(prompt)
                val input: String = reader.read() ?: throw IllegalArgumentException("입력 값이 null 입니다.")
                return CarNames(input).getProperFormatCarNames()
            } catch (e: Exception) {
                println("[$e] 입력 문자열을 확인해주세요.")
            }
        }
    }

    /**
     * 정수형 숫자를 입력 받는다.
     * @param prompt 입력을 유도하는 문자열
     * @throws IllegalArgumentException 입력 값이 null 이거나 적절한 정수형의 숫자가 아닌 경우
     * */
    fun inputNumber(prompt: String): Int {
        while (true) {
            try {
                print(prompt)
                val input: String = reader.read() ?: throw IllegalArgumentException("입력 값이 null 입니다.")
                return Number(input).toInt()
            } catch (e: Exception) {
                println("[$e] 입력 숫자를 확인해주세요.")
            }
        }
    }
}
