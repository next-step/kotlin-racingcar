package controller

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.controller.CarRacingRequest
import racingcar.domain.car.CarName

class CarRacingRequestTest : FunSpec({
    test("이름과 횟수로 CarRacingRequest가 생성된다") {
        val names = listOf("test1", "test2")
        val tryCount = 2

        val result = CarRacingRequest(
            roundCount = tryCount,
            carNames = names
        )

        result.carNames shouldBe listOf(CarName("test1"), CarName("test2"))
        result.roundCount shouldBe tryCount
    }

    test("자동차 이름으로 빈 리스트가 전달되면 CarRacingRequest가 생성에 실패한다") {
        val names = emptyList<String>()

        shouldThrowExactly<IllegalArgumentException> {
            CarRacingRequest(
                roundCount = 1,
                carNames = names,
            )
        }
    }

    test("시도 횟수가 양수가 아닐 경우 CarRacingRequest가 생성에 실패한다") {
        val tryCount = -1

        shouldThrowExactly<IllegalArgumentException> {
            CarRacingRequest(
                roundCount = tryCount,
                carNames = listOf("teset"),
            )
        }
    }

    test("5글자 이상의 이름이 전달되면 CarRacingRequest가 생성에 실패한다") {
        val names = listOf("kim", "abcdef")

        shouldThrowExactly<IllegalArgumentException> {
            CarRacingRequest(
                roundCount = 1,
                carNames = names,
            )
        }
    }
})
