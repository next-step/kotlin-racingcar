package study.racing.rule

import racing.domain.rule.RuleInterface

class FakeRule : RuleInterface {
    override fun isMove(): Boolean = true
}
