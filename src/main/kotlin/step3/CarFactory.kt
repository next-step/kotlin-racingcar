package step3

object CarFactory {

    fun create(amount: Int): Cars {
        validateCarAmount(amount)
        return IntRange(1, amount)
            .map { Car(CarMover()) }
            .run { Cars(this) }
    }
    // 마지막 Cars를 만드는 과정에서 확장함수 run, let중 어떤것을 쓸지 고민이었습니다.
    // 둘다 T를 수신자로 받고, 새로운 R을 반환한다는 점에서 기능상 문제는 없다고 생각하지만
    // (어떤 차이가 있는지 내부 코드가 다름을 알지만 기능적으로 어떻게 다른지는 잘 모릅니다 ㅠㅠ)
    // run - 수신자를 가지고 작업을 한다.
    // let - 수신자를 이렇게 정의하자.
    // 라고 생각이 들어서 가독성 문제로 run을 택했습니다. 어떤게 더 맞는 선택일까요?
    // 제 생각이 바른 방향인지도 궁금합니다.

    private fun validateCarAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("자동차의 개수는 반드시 1개 이상입니다. 입력 값 : $amount")
        }
    }
}
