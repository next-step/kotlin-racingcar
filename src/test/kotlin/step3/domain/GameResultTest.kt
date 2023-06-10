package step3.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameResultTest : StringSpec({
    "[getLastPositions 테스트] 결과가 없으면 초기 위치를 리턴한다." {
        val initialPositions = CarPositions.of(size = 3, initialPosition = 0)
        val gameResult = GameResult(initialPositions)

        gameResult.getLastPositions() shouldBe initialPositions
    }

    "GameResult 내부 리스트는 외부에서 변경할 수 없다." {
        val carPositions = CarPositions(positions = listOf())
        val list = mutableListOf(carPositions)
        val gameResult = GameResult(
            initialPositions = carPositions,
            positionsResult = list
        )

        list.clear()

        gameResult.getPositionsResult().size shouldBe 1
    }
})
