# kotlin-racingcar
## 1. calculator
### 기능 요구 사항
* 더하기 기능
* 빼기 기능
* 곱하기 기능
* 나누기 기능 구현
    * 0으로 나눌 수 없다.
* 수식 검증 기능
    * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
    * 입력 수식 " "로 파싱 후 사이즈가 3 미만이거나 홀수가 아닐 경우 IllegalArgumentException throw
    * 입력 수식 " "로 파싱 후 짝수 인덱스가 숫자, 홀수 인덱스가 연산자가 아닐 경우 IllegalArgumentException throw

### 기능 목록
* [CaculatorApplication] 메인 클래스
* [Operator] 사칙 연산자를 관리하는 클래스
* [ExpressionValidator] 입력된 값이 계산이 가능한지 검증하는 클래스
* [Calculator] 계산을 진행하는 클래스

---
