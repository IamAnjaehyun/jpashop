package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장 타입
    private Address address;

    @OneToMany(mappedBy = "member") //매핑된 거울일 뿐이면 mappedBy
    private List<Order> order = new ArrayList<>();


}
