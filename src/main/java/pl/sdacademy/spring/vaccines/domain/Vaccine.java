package pl.sdacademy.spring.vaccines.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class Vaccine {

    @Id
    String id;

    String name;
    String surname;
    String comments;
    String sex;
    Short type;
    boolean firstWish;
    boolean secondWish;
}
