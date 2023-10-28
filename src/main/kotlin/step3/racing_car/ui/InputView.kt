package step3.racing_car.ui

/**
 * 자동차 경주의 입력 뷰를 그리는 클래스
 *
 * @author KimJungSik
 * @since 2023/10/28
 * */
class InputView {

    enum class InputType(val description: String) {
        CAR("자동차 대수는 몇 대인가요?\n"), ROUND("시도할 횟수는 몇 회인가요?\n")
    }

    /**
     * input 타입에 따라 다른 뷰를 그림
     * */
    fun draw(inputType: InputType) {
        print(inputType.description)
    }
}