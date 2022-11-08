package racing.domain

class FakeRandomMovingCarConditionNumber : RandomMovingCarConditionNumber {
    private var fakeTryNumber: Long = 0

    // 홀수 일 때 스탑(3), 짝수 일때 전진(4) 넘기는 fake mock
    override fun random(): Int =
        if ((fakeTryNumber++ % 2).toInt() == 0) 4 else 3
}
