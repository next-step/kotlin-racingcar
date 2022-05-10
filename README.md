# kotlin-racingcar

### 기능 요구 사항

입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기
입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
사칙연산 기호가 아닌 경우 IllegalArgumentException throw

[X] 덧셈
[X] 뺄셈
[X] 곱셈
[X] 나눗셈

### 프로그래밍 요구사항

메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 엣지케이스

[X] 시작이 숫자가 아닌 경우
[X] 끝이 숫자가 아닌 경우
[X] 문자가 들어있는 경우
[X] 0으로 나누는 경우 arithmetic Exception을 던진다.
[X] 연산자가 연속으로 나온 경우

### 기타 구현

[X] ParameterizedTest
[ ] 입력 기능 (readln()) 추가
[ ] 연산자를 ENUM으로 구현