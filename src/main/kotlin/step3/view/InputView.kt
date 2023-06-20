package step3.view

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 */
class InputView {

    fun inputNumOfGame(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readNumber()
    }

    fun inputNameOfCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        var nameList = readName()
        while (!isValidName(nameList)){
            println("자동차 이름은 1글자 이상 5글자 이하여야 합니다. 다시 입력해 주세요.")
            nameList = readName()
        }
        return nameList
    }

    private fun readName(): List<String>? {
        return readLine()?.split(",")
    }

    @OptIn(ExperimentalContracts::class)
    private fun isValidName(nameList: List<String>?): Boolean {
        contract {
            returns() implies (nameList != null)
        }
        return (nameList != null) && nameList.all { it.length in 1..5 }
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }
}