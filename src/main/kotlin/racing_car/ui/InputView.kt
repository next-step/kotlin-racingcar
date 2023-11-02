package racing_car.ui

private const val INPUT_CAR_NAME_LIST_VIEW = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n"
private const val INPUT_ROUND_DESCRIPTION_VIEW = "시도할 횟수는 몇 회인가요?\n"

/**
 * 자동차 경주의 입력 뷰를 그리는 클래스
 * */
object InputView {

    enum class InputType(val descriptionView: String) {
        CAR_NAME_LIST(INPUT_CAR_NAME_LIST_VIEW), ROUND_COUNT(INPUT_ROUND_DESCRIPTION_VIEW)
    }

    /**
     * input 타입에 따라 다른 뷰를 그림
     * */
    fun draw(inputType: InputType) {
        print(inputType.descriptionView)
    }
}