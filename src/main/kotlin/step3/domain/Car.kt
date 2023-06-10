package step3.domain

/**
 * ### 자동차 클래스 입니다.
 *
 * 외부에서 넘겨받은 무작위 값에 따라 전진 여부를 결정 합니다.
 */
class Car {

    var position: Int = 0
        private set

    fun move(randomValue: Int) {
        position += if (randomValue >= 4) 1 else 0
    }
}
