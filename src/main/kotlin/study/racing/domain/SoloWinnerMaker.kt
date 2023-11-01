package study.racing.domain

/*
 *   이동 가능/불가의 비율은 5:5로 구성된다.
 *   차량 수 * 라운드수 / 2
 *   예를들어, 차량 3대, 라운드2회 기준으로 중복없이 이동가능, 불가를 생성한다면
 *   [x축][y축] 좌표 기준으로
 *   [0][0], [1][0], [1][1] -> true
 *   [0][1], [0][2], [1][2] -> false
 *   이를 만족하는 조건은
 *   라운드 인덱스가 카 인덱스보다 크거나 같으면 true
 *   반대면 false를 주면 거리가 같지 않은 경우의 수에 충족하는 하나의 승리자가 만들어진다.
 *   전체 경우의 수를 순차적으로 생성하고 이를 차량의 index와 맵핑을 해준다.
 *   여기서 랜덤한 승자를 선출하기 위해 맵핑대상 인덱스 콜랙션값은
 *   기존 차량의 index를 셔플해서 반환한 콜랙션을 사용한다.
*/
object SoloWinnerMaker {

    fun makeWinnerByFirstSorting(
        carCount: Int,
        roundCount: Int,
        carSortIndex: List<Int>,
    ): Map<Int, List<Boolean>> {

        require(carCount - 1 == roundCount) {
            "단독 우승 방식을 선택 하셨습니다. 라운드 수를 '차량수-1' 로 설정해 주세요"
        }

        require(carSortIndex.size == carCount) {
            "생성되는 차량과 정렬되는 차량의 수가 일치하지 않습니다."
        }

        val racingRecords = mutableMapOf<Int, List<Boolean>>()

        repeat(carCount) { cIndex ->
            val racingRecordByCar = mutableListOf<Boolean>()

            createRaceRecordsEachRound(
                roundCount,
                cIndex,
                racingRecordByCar,
            )
            mappingRecordByCarSortIndexASC(
                racingRecords,
                carSortIndex,
                cIndex,
                racingRecordByCar
            )
        }
        return racingRecords
    }

    private fun mappingRecordByCarSortIndexASC(
        result: MutableMap<Int, List<Boolean>>,
        carSortIndex: List<Int>,
        cIndex: Int,
        racingRecordByCar: MutableList<Boolean>
    ) {
        result[carSortIndex[cIndex]] = racingRecordByCar
    }

    private fun createRaceRecordsEachRound(
        roundCount: Int,
        cIndex: Int,
        racingRecordByCar: MutableList<Boolean>,
    ) {
        repeat(roundCount) { rIndex ->
            racingRecordByCar.add(isMoving(cIndex, rIndex))
        }
    }

    private fun isMoving(cIndex: Int, rIndex: Int): Boolean {
        return cIndex <= rIndex
    }
}
