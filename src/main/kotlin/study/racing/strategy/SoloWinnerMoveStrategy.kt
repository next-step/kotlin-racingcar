package study.racing.strategy

import study.racing.domain.SoloWinnerMaker

class SoloWinnerMoveStrategy(
    roundCount: Int = 0,
    carCount: Int = 0,
    shuffledCarIndex: List<Int> = listOf(),
) : MoveStrategy {

    private val matchPrediction = SoloWinnerMaker.makeWinnerByFirstSorting(
        carCount,
        roundCount,
        shuffledCarIndex
    )

    init {
        require(matchPrediction.isNotEmpty()) {
            "승부예측이 정상적으로 생성되지 않았습니다. 게임을 다시 시도해 주세요."
        }

        require(matchPrediction.keys.isNotEmpty()) {
            "해당 차량의 승부예측이 정상적으로 생성되지 않았습니다. 게임을 다시 시도해 주세요."
        }
    }

    override fun isMoving(): Boolean {
        return RandomMoveStrategy().isMoving()
    }

    override fun isMoving(
        carIndex: Int,
        roundIndex: Int
    ): Boolean {

        require(matchPrediction.keys.size > carIndex) {
            "요청한 차량의 승부 예측이 존재하지 않습니다."
        }

        require(matchPrediction.values.size > roundIndex) {
            "요청한 차량의 해당 라운드 승부 예측이 존재하지 않습니다."
        }

        return matchPrediction.filter {
            it.key == carIndex
        }.map {
            it.value[roundIndex]
        }.first()
    }
}
