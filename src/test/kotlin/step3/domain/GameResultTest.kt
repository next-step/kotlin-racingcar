package step3.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameResultTest : StringSpec({
    "[getLastPositions 테스트] 결과가 없으면 초기 위치를 리턴한다." {
        val initialPositions = CarPositions.of(size = 3, initialPosition = 0)
        val gameResult = GameResult(initialPositions)

        gameResult.getLastPositions() shouldBe initialPositions
    }
})
