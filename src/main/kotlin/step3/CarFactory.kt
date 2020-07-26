package step3

object CarFactory {

    fun create(amount: Int): Cars {
        validateCarAmount(amount)
        return IntRange(1, amount)
            .map { Car(CarMover()) }
            .let { Cars(it) }
        // run?? let??
    }

    private fun validateCarAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("자동차의 개수는 반드시 1개 이상입니다. 입력 값 : $amount")
        }
    }
}
