package racing.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class WinnerTest : DescribeSpec({

    describe("Winner 테스트") {
        it("가장 멀리 간 자동차의 이름 리스트를 반환한다.") {
            // given
            val winner = Winner(
                listOf(
                    Car(0, "A"),
                    Car(2, "B"),
                    Car(3, "C"),
                )
            )

            // when

            // then
            winner shouldBe "C"
        }
    }
})
