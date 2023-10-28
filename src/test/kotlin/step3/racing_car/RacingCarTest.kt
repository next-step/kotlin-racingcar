package step3.racing_car

import io.kotest.core.spec.style.FunSpec
import step3.racing_car.ui.InputView

/**
 * 자동차 경주 단위 테스트 클래스
 *
 * @author KimJungSik
 * @since 2023/10/28
 * */
class RacingCarTest: FunSpec({

    test("자동차 대수나 횟수를 입력하지 않은 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("")
    }

    test("자동차 대수나 횟수에 문자를 입력하는 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("셋")
    }

    test("자동차 대수나 횟수를 0으로 입력하는 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("0")
    }

    test("자동차 대수나 횟수를 음수로 입력하는 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("-1")
    }

    test("자동차 대수나 횟수를 2147483647 보다 높게 입력하는 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("2147483648")
    }

    test("자동차 대수나 횟수를 2147483647 보다 낮게 입력하는 경우 에러가 발생하는지 확인한다") {
        RacingCar.errorCheck("1")
        RacingCar.errorCheck("128367")
        RacingCar.errorCheck("2147483646")
    }
})