package racing.domain

class RandomNumberForwardCondition : ForwardCondition {

    override fun getForwardCondition(): Boolean {
        return (0..MAX_FORWARD_CONDITION).random() >= MIN_FORWARD_CONDITION
    }

    companion object {
        private const val MIN_FORWARD_CONDITION = 4
        private const val MAX_FORWARD_CONDITION = 9
    }
}
