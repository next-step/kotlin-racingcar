package domain.racingcar

import java.util.LinkedList

class MockConditions(private val conditions: LinkedList<Int>) : Conditions {
    override fun makeCondition(): Int {
        return conditions.pop()
    }
}
