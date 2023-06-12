package racing.mock

import racing.domain.ForwardCondition

class FakeForwardCondition(
    private val condition: Boolean
) : ForwardCondition {
    override fun getForwardCondition() = condition
}
