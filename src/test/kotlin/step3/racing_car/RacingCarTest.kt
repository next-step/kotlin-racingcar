package step3.racing_car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
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

    test("자동차 대수나 횟수를 2147483647 보다 낮게 입력하는 경우 정상 동작을 하는지 확인한다") {
        RacingCar.errorCheck("1")
        RacingCar.errorCheck("128367")
        RacingCar.errorCheck("2147483646")
    }

    test("0이상 4이하 일 때 false(대기)로 나오는지 확인한다") {
        (0 until 4).forEach {
            RacingCar.isAdvance(it) shouldBe false
        }
    }

    test("5이상 9이하 일 때 true(전진)로 나오는지 확인한다") {
        (5 until 9).forEach {
            RacingCar.isAdvance(it) shouldBe true
        }
    }

    test("자동차 레이싱 1 라운드 실행시 결과 값에 1이 추가 되었는지 확인한다") {
        val list = listOf(listOf(1), listOf(1), listOf(1))
        val resultList = RacingCar.playRound(list)
        resultList[0].size shouldBe 2
        resultList[1].size shouldBe 2
        resultList[2].size shouldBe 2
    }

    test("자동차 레이싱 20 라운드 실행시 결과 값에 20이 추가 되었는지 확인한다") {
        val list = listOf(listOf(1), listOf(1), listOf(1))
        var resultList: List<List<Int>> = list
        repeat(20) {
            resultList = RacingCar.playRound(resultList)
        }
        resultList[0].size shouldBe 21
        resultList[1].size shouldBe 21
        resultList[2].size shouldBe 21
    }

})