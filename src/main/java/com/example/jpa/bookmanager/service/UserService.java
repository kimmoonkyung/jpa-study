package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    // 1. 비영속 상태
    @Transactional
    public void put() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");
        // @Transactional 이러한 상태의 유저는 비영속 상태(즉 new 상태) -> 아직 영속성 컨텍스트 안에서 관리 되지 않는 상태
        // 테스트 코드에서 조회해보면, select 쿼리는 동작 하지만 값은 존재하지 않는다.
        // 엔티티로서 유저라는 객체가 디비와 연결이 된것이 아니라 단순히 자바객체로만 존재하다,
        // 메소드 호출이 종료 되면 영속화 되지 않고 가비지 컬렉터를 통해 사라지는 데이터가 될 것이다.
    }

    // 2. 영속 상태
    @Transactional
    public void put2() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);
        // persist 를 실행하면 영속성 컨텍스트가 해당 엔티티를 관리하는 상태, 매니지드 상태가 된다.
    }

    // 2-1. 영속성 컨텍스트가 해당 객체를 관리하게 되면 어떠한 차이점이 있는가 ?
    @Transactional
    public void put2_1() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);
        user.setName("충내개명");
        // user.setName("충내개명"); -> 을 하게 되면 디비에 저장되지 못하고 가비지컬렉터에 의해 소멸하게 될까 ?
        // X. insert 이후 update 쿼리가 수행되며 변경한 name이 디비에 저장되어있다.
        // 영속성 컨텍스트 내에서 관리되는 엔티티는 세터를 통해 엔티티의 정보가 변경 된 경우,
        // 트랜잭션이 완료되는 시점에 별도로 세이브 메소드를 호출하지 않더라도 디비데이터와 정합성을 맞춰준다.
        // update 쿼리가 실행 된 부분이 영속성 컨텍스트가 제공해주는 더티체크라는 기능이다.
        // 영속성 컨텍스트에서 가지고 있는 엔티티 객체는 처음 컨텍스트에 로드를 할떄 해당 정보를 일종의 스냅샷으로 복사해서 가지고 있는다.
        // 그런 후에 변경내용을 디비에 적용하는 시점(flush, 트랜잭션 종료후 커밋, jpql쿼리가 실행되는)에 디비에 적용하려고 볼 때,
        // 해당 스냅샷과 현재 엔티티의 값을 일일히 비교하여 변경 된 내용이 있다면 디비에 반영 해준다.
    }

    // 3. 준영속 컨텍스트 (detached)
    @Transactional
    public void put3() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);
        entityManager.detach(user);

        user.setName("충내개명");
        // 영속화 되었던 객체를 detached(: 떨어져 있는) 분리해서 영속성 컨텍스트 밖으로 꺼내는 동작.
        // persist한 이후에 detach를 하면 유저 엔티티는 영속성 컨텍스트에서 더이상 관리하지 않는다.
        // user.setName을 했지만 update 쿼리는 실행되지 않았다.

    }

    // 3. 준영속 컨텍스트 (detached)
    @Transactional
    public void put3_1() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);
        entityManager.detach(user);

        user.setName("충내개명");
        entityManager.merge(user);
        // detach 했어도 merge를 해주면 디비에 반영 된다.
    }

    // 3. 준영속 컨텍스트 (detached)
    @Transactional
    public void put3_2() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);
        entityManager.detach(user);

        user.setName("충내개명");
        entityManager.merge(user);

        entityManager.flush();
        entityManager.clear();
        // detach가 아니여도 clear나 close를 사용해도 비슷하게 영속성 컨텍스트에 들어 있는 엔티티를 밖으로 꺼내게 되는데,
        // clear나 close는 좀 더 파괴적인 방법이다. clear는 기존에 반영하려고 컨텍스트에 변경 예약되어 있던 것들도 모두 드랍하게 된다.
        // persist까지는 실행 되지만 merge의 작업(변경)이 드랍 되었다.
        // clear를 호출하기전에 반드시 flush()를 호출하게 해서 변경 내용들을 모두 반영하길 권고한다.
    }

    // 4. 삭제 컨텍스트 (remove)
    @Transactional
    public void put4() {
        User user = new User();
        user.setName("귀염둥이충내");
        user.setEmail("귀염둥이충내@커염둥이충내.com");

        entityManager.persist(user);

        user.setName("충내개명");
        entityManager.merge(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("민주노총내");
        entityManager.merge(user1); // deleted instance passed to merge 지워진 인스턴스는 머지할 수 없다.
    }

}
