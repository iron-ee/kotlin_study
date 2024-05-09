package main.kotlin.fp.collection

/*
컬렉션의 null 가능성
- List<Int?>  : 리스트에 null 이 들어갈 수 있지만, 리스트는 절대 null 이 아님
- List<Int>?  : 리스트에는 null 이 들어갈 수 없지만, 리스트는 null 일 수 있음
- List<Int?>? : 리스트에 null 이 들어갈 수도 있고, 리스트가 null 일 수도 있음
 */

/*
java 와 함께 사용할 때 매우 매우 주의할 점
1. java 는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다.
 =>  1) kotlin -> java 로 불변 리스트 전송
     2) java 에서는 불변인지 가변인지 알빠 없음 -> element 추가해버려 -> kotlin 으로 다시 돌려줄게
     3) kotlin 입장에서는 -> 어..? 불변인데 element 가 추가되었네..? -> error

2. java 는 Null Safety 가 없기 때문에 nullable 타입과 non-nullable 타입을 구분하지 않는다.
 =>  1) kotlin -> java 로 non-nullable 리스트 전송
     2) java 에서는 우리는 그런거 몰라~ null 을 리스트에 추가 -> kotlin 으로 다시 돌려줄게
     3) kotlin 입장에서는 -> null ??!!!!... -> error

그래서 kotlin 쪽의 컬렉션이 java 에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 한다.
kotlin 쪽에서 Collections.unmodifableXXX() 를 활용하면 변경 자체를 막을 수는 있음.

3. kotlin 에서 java 컬렉션을 가져다 사용할 때 플랫폼 타입을 신경써야 한다.
 =>  1) java -> kotlin 으로 List<Integer> 전송
     2) kotlin 에서는 이게 List<Int?>, List<Int>?, List<Int?>? 무엇인지 판별 못함

그래서 java 코드를 보며, 맥락을 확인하고 java 코드를 가져오는 지점을 wrapping 해야 함
 */



/*
kotlin 에서는 컬렉션을 만들 때도 불변/가변을 지정해야 한다.
List, Set, Map 에 대한 사용법이 변경, 확장되었다.
java 와 kotlin 코드를 섞어 컬렉션을 사용할 때에는 주의해야 한다.
 - java 에서 kotlin 컬렉션을 가져갈 때는 불변 컬렉션을 수정할 수도 있고, non-nullable 컬렉션에 null 을 넣을 수도 있다.
 - kotlin 에서 java 컬렉션을 가져갈 때는 플랫폼 타입을 주의해야 한다.
 */