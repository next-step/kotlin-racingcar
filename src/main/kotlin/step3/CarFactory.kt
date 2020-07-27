package step3

object CarFactory {

    fun create(carNames: List<String>): Cars {
        validateCarAmount(carNames.size)
        return carNames
            .map { Car(it, CarMover()) }
            .let { Cars(it) }
    }

    private fun validateCarAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("자동차의 개수는 반드시 1개 이상입니다. 입력 자동차 수 : $amount")
        }
    }
}
