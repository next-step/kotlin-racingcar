package step3.racing_car

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * 자동차 경주 단위 테스트 클래스
 * */
class RacingCarTest: FunSpec({

    test("자동차 게임 시작 파라미터의 자동차 대수와 라운드 횟수에 문자열을 전달할 경우 예외를 던진다.") {
        RacingGame.run("", "") { }
    }

    test("자동차 게임 시작 파라미터의 자동차 대수에 빈문자열을 입력하는 경우 예외를 던진다.") {
        RacingGame.run("", "1") { }
    }

    test("자동차 게임 시작 파라미터의 라운드 횟수에 빈문자열을 입력하는 경우 예외를 던진다.") {
        RacingGame.run("1", "") { }
    }

    test("자동차 게임 시작 파라미터의 자동차 대수에 유효하지 않은 문자를 입력하는 경우 예외를 던진다.") {
        RacingGame.run("일", "1") { }
    }

    test("자동차 게임 시작 파라미터의 라운드 횟수에 유효하지 않은 문자를 입력하는 경우 예외를 던진다.") {
        RacingGame.run("1", "ㅁ") { }
    }

    test("자동차 게임 시작 파라미터의 자동차 대수와 라운드 횟수에 숫자 0을 전달할 경우 예외를 던진다.") {
        RacingGame.run("0", "0") { }
    }

    test("자동차 게임 시작 파라미터의 자동차 대수에 숫자 0을 전달할 경우 예외를 던진다.") {
        RacingGame.run("0", "1") { }
    }

    test("자동차 게임 시작 파라미터의 라운드 횟수에 숫자 0을 전달할 경우 예외를 던진다.") {
        RacingGame.run("1", "0") { }
    }

    test("자동차 게임 시작 파라미터의 자동차 대수에 음수를 전달할 경우 예외를 던진다.") {
        RacingGame.run("-1", "1") { }
    }

    test("자동차 게임 시작 파라미터의 라운드 횟수에 음수를 전달할 경우 예외를 던진다.") {
        RacingGame.run("1", "-1") { }
    }

    test("자동차를 움직일 때 무작위 값이 0미만 이라면 예외를 던진다.") {
        val car = Car(0)
        car.move(-1)
        car.position shouldBe 0
    }

    test("자동차를 움직일 때 무작위 값이 9초과 라면 예외를 던진다.") {
        val car = Car(0)
        car.move(10)
        car.position shouldBe 0
    }

    test("자동차를 움직일 때 무작위 값이 0이상 3이하 라면 정지로 나와야 한다") {
        (0 until 4).forEach {
            val car = Car(0)
            car.move(it)
            car.position shouldBe 0
        }
    }

    test("자동차를 움직일 때 무작위 값이 4이상 9이하 라면 전진으로 나와야 한다") {
        (5 until 9).forEach {
            val car = Car(0)
            car.move(it)
            car.position shouldBe 1
        }
    }

})