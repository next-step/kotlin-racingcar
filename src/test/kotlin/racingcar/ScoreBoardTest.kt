package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class ScoreBoardTest : StringSpec({
    "최초 생성 시 전달받은 차량의 이름과 각각의 row를 가진 보드 객체를 생성한다." {
        val carNames = listOf("test1", "test2", "test3")
        val scoreBoard = ScoreBoard(carNames)

        scoreBoard.board.keys.toList() shouldBe carNames
        scoreBoard.board.values.forAll { it.shouldBeInstanceOf<PhaseResultRow>() }
    }

    "전달받은 차량에 대하여 결과를 기록할 수 있다." {
        val carNames = listOf("test1", "test2", "test3")
        val scoreBoard = ScoreBoard(carNames)
        scoreBoard.recordPhase(Car("test1", 1))

        val phaseRecord = scoreBoard.board["test1"]?.getPhaseRecord(0)
        phaseRecord shouldBe 1
    }

    "최종 우승자를 계산할 수 있다." {
        val carNames = listOf("test1", "test2", "test3")
        val scoreBoard = ScoreBoard(carNames)
        carNames.forEachIndexed { index, name -> scoreBoard.recordPhase(Car(name, index)) }

        val calculateWinner = scoreBoard.calculateWinner()
        calculateWinner shouldBe listOf("test3")
    }
})
