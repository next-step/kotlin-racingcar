package racing_car.ui

private const val INPUT_CAR_DESCRIPTION_VIEW = "자동차 대수는 몇 대인가요?\n"
private const val INPUT_ROUND_DESCRIPTION_VIEW = "시도할 횟수는 몇 회인가요?\n"

/**
 * 자동차 경주의 입력 뷰를 그리는 클래스
 * */
object InputView {

    enum class InputType(val descriptionView: String) {
        CAR(INPUT_CAR_DESCRIPTION_VIEW), ROUND(INPUT_ROUND_DESCRIPTION_VIEW)
    }

    /**
     * input 타입에 따라 다른 뷰를 그림
     * */
    fun draw(inputType: InputType) {
        print(inputType.descriptionView)
    }
}