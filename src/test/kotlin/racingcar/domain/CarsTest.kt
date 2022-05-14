package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec

class CarsTest : FunSpec({
    test("Cars 객체를 생성한다") {
        // given
        val cars = listOf(
            Car(),
            Car(),
        )

        // when // then
        shouldNotThrowAny { Cars(cars) }
    }

    test("자동차가 2대 미만일 때, 자동차 경주 게임을 생성하면 예외를 발생시킨다.") {
        // given
        val cars = listOf(Car())

        // when // then
        shouldThrowExactly<IllegalArgumentException> { Cars(cars) }
    }
})
