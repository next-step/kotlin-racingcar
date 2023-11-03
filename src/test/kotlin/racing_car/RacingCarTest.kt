package racing_car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racing_car.model.Car
import racing_car.parser.RacingParser

/**
 * 자동차 경주 단위 테스트 클래스
 * */
class RacingCarTest : FunSpec({

    test("자동차 리스트 변환기 파라미터에 빈문자열을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToCarList("")
    }

    test("자동차 리스트 변환기 파라미터에 5자 초과의 문자열을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToCarList("abcdef")
    }

    test("자동차 리스트 변환기 파라미터에 \",\" 문자열을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToCarList(",")
    }

    test("자동차 라운드 횟수 변환기 파라미터에 빈문자열을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToRoundCnt("")
    }

    test("자동차 라운드 횟수 변환기 파라미터에 유효하지 않은 문자열을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToRoundCnt("삼")
    }

    test("자동차 라운드 횟수 변환기 파라미터에 0을 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToRoundCnt("0")
    }

    test("자동차 라운드 횟수 변환기 파라미터에 음수를 전달할 경우 예외를 던진다.") {
        RacingParser.convertTextToRoundCnt("-1")
    }

    test("자동차 생성자 이름 파라미터에 빈문자열을 입력하면 예외를 던진다.") {
        Car("")
    }

    test("자동차 생성자 이름 파라미터에 \"JungSik\"을 입력하면 예외를 던진다.") {
        Car("JungSik")
    }

    test("자동차 생성자 이름 파라미터에 \"Jung\"을 입력하면 자동차의 이름이 \"Jung\"이 된다.") {
        val car = Car("Jung")
        car.getName() shouldBe "Jung"
    }

    test("자동차 생성 직후 전진 함수 파라미터에 -1을 입력하면 예외를 던진다.") {
        val car = Car("Jung")
        car.move(-1)
    }

    test("자동차 생성 직후 전진 함수 파라미터에 10을 입력하면 예외를 던진다.") {
        val car = Car("Jung")
        car.move(10)
    }

    test("자동차 생성 직후 전진 함수 파라미터에 1이상 4미만을 입력하면 자동자의 위치를 0으로 유지한다") {
        (0..3).forEach {
            val car = Car("Jung")
            car.move(it)
            car.getCurrentPosition() shouldBe 0
        }
    }

    test("자동차 생성 직후 전진 함수 파라미터에 5이상 9이하를 입력하면 자동자의 위치가 1로 이동한다.") {
        (4..9).forEach {
            val car = Car("Jung")
            car.move(it)
            car.getCurrentPosition() shouldBe 1
        }
    }

})