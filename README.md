# kotlin-racingcar

## [step 2] 문자열 사칙 연산 계산기

### 요구 사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 구현 목록

- [ ] 덧셈, 뺄셈, 곱셈, 나눗셈 기능
- [ ] 숫자, 연산자 분리 기능
- [ ] 다중 연산 기능
- [ ] 입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw 기능
- [ ] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw 기능
- [ ] 띄어쓰기가 한칸씩이 아닐 경우 IllegalArgumentException throw 기능
