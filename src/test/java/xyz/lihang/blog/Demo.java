package xyz.lihang.blog;

import java.io.Serializable;

/**
 * Created by LiHang on 2017/8/11.
 */
public class Demo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

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

    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
