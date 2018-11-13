package club.javalearn.common.jpa;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * @author king-pan
 * @date 2018/11/13
 * @Description ${DESCRIPTION}
 */
public class BeanTest {

    @Test
    public void test1(){
        Person p1 = new Person();
        p1.setAddress("p1的家庭住址");
        p1.setId(1L);
        p1.setName("zs");

        Person p2 = new Person();
        p2.setAddress("更新P1的家庭住址");
        p2.setNickeName("新增昵称");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("========================");
        BeanUtils.copyProperties(p2,p1,getNullPropertyNames(p2));
        System.out.println(p1);
        System.out.println(p2);

    }

    public static String[] getNullPropertyNames(Object source) {
        Set<String> emptyNames = getNullPropertyNameSet(source);
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static Set<String> getNullPropertyNameSet(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames;
    }
}
