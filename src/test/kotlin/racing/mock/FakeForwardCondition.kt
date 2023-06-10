package racing.mock

import racing.ForwardCondition

class FakeForwardCondition(
    private val condition: Boolean
) : ForwardCondition {
    override fun getForwardCondition() = condition
}
