package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class RacingResultsTest : FunSpec({
    test("add 함수를 호출하여 요소를 더한 RacingResult 객체를 반환받을 수 있다.") {
        // given
        val racingResults = RacingResults(listOf(RacingResult(1, Cars(List(1) {Car(1, CarName.of("charlie"))}))))

        // when
        val sut = racingResults.add(RacingResult(2, Cars(List(1) {Car(2, CarName.of("charlie"))})))

        // then
        sut.value.size shouldBe 2
    }
})
