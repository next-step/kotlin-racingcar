package racing.domain

import racing.controller.GameUserInputInterface
import racing.controller.RandomNumberInput

/*
자동차 정보 클래스
- 자동차의 이름 등 특징을 갖는 클래스 : 하위 클래스로 구현
- 사용자 입력(random)에 대해 다음 동작을 결정하는 함수 필요
 */
class CarModel(inputName: String, private val controller: GameUserInputInterface = RandomNumberInput(), initPosition: Int = 0) {
    var currentPosition: Int = initPosition
        private set

    val name: String

    init {
        require(inputName.length <= MAX_CAR_NAME_LENGTH) {
            "자동차 이름을 확인해 주세요"
        }
        name = inputName
    }

    fun nextState() {
        val inputNumber = controller.generateNextNumber()
        currentPosition += if (inputNumber >= INPUT_THRESHOLD) 1 else 0
    }

    companion object {
        private const val INPUT_THRESHOLD = 4
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
