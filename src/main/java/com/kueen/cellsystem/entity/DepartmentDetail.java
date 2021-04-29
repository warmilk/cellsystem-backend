package com.kueen.cellsystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter //项目中经常使用bean，entity等类，绝大部分数据类类中都需要get、set、toString、equals和hashCode方法，尽管IDE工具都会帮我们生成。但自动生成这些代码后，如果bean中的属性一旦有修改、删除或增加时，需要重新生成或删除get/set等方法，给代码维护增加负担。而使用了lombok之后，就不需要编写或生成setter或getter等方法了，而使用lombok注解的方式，在编译生成的字节码文件中就会存在setter/getter等方法，这样就大大减少了代码量，方便了代码的维护。
@Setter
public class DepartmentDetail {
    private int id;
    private String name;
}
