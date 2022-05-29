package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class RacingResultsTest : FunSpec({
    test("add 함수를 호출하여 하나의 레이싱 결과를 추가한 RacingResults 객체를 반환받을 수 있다.") {
        // given
        val carList = List(1) { Car(1, CarName.of("charlie")) }
        val cars = Cars(carList)
        val racingResultList = listOf(RacingResult(1, cars))
        val sut = RacingResults(racingResultList)

        val racingResult = RacingResult(2, Cars(List(1) { Car(2, CarName.of("charlie")) }))

        // when
        val result = sut.add(racingResult)

        // then
        result.value.size shouldBe 2
    }
})
