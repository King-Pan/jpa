package club.javalearn.common.jpa;

import lombok.Data;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
@Data
public class Person {
    private Long id;
    private String name;
    private String nickeName;
    private int age;
    private String address;
}
