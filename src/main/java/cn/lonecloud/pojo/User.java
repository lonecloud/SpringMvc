package cn.lonecloud.pojo;

/**
 * @author lonecloud
 * @version v1.0
 * @date 下午7:57 2017/11/5
 */
public class User {

    private String id;

    private String name;

    private int  age;

    private Group group;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
