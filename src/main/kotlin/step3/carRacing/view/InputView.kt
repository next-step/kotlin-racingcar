package step3.carRacing.view

import step3.carRacing.Action
import step3.carRacing.DispatchHandler
import step3.carRacing.Payload

class InputView(private val dispatchHandler: DispatchHandler<Action, Payload>) {

    private fun input(): Pair<Int, Int> { // private 메서드는 어떻게 테스트하지?!
        println("경주할 자동차 대수를 입력하세요")
        val carCount = readLine()!!.toInt()
        println("시도할 회수는 몇회인가요?")
        val tryCount = readLine()!!.toInt()

        return Pair(carCount, tryCount)
    }

    fun start() { // 사이드 이펙트를 일으키는 메서드는 테스트를 해야하나?!
        val (carCount, tryCount) = input()
        dispatchHandler.dispatch(Action.FINISH_INPUT, Payload.FinishInput(carCount, tryCount))
    }
}
