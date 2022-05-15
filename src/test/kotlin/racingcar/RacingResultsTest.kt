package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class RacingResultsTest : FunSpec({
    test("add 함수를 호출하여 요소를 더한 RacingResult 객체를 반환받을 수 있다.") {
        // given
        val racingResults = RacingResults(listOf(RacingResult(1, listOf(1))))

        // when
        val sut = racingResults.add(RacingResult(2, listOf(2)))

        // then
        sut.values.size shouldBe 2
    }
})
