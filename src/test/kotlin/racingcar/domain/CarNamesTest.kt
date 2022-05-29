package racingcar.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class CarNamesTest : FunSpec({

    test("자동차 이름들을 2개 가지고 있는 CarNames 객체에 size() 함수를 호출하면, 2를 반환한다.") {
        // given
        val sut = CarNames(listOf(CarName.of("11"), CarName.of("22")))

        // when
        val result = sut.size()

        // then
        result shouldBe 2
    }

    test("자동자 이름들 2개를 가지고 있는 carNames 객체에 carNames[0]과 같이 사용해서, 첫 번째 요소를 가져올 수 있다.") {
        // given
        val sut = CarNames(listOf(CarName.of("11"), CarName.of("22")))

        // when
        val result = sut[0]

        // then
        result shouldBe CarName.of("11")
    }
})
