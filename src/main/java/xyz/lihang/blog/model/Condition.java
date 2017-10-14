package xyz.lihang.blog.model;

/**
 * Created by LiHang on 2017/8/7.
 */
public class Condition {

    //类别id
    private Integer cid;

    //标签Id
    private Integer lid;


    private String date;


    public Integer getCid() {
        return cid;
    }

    public Condition setCid(Integer cid) {
        this.cid = cid;
        return  this;
    }

    public Integer getLid() {
        return lid;
    }

    public Condition setLid(Integer lid) {
        this.lid = lid;
        return  this;
    }

    public String getDate() {
        return date;
    }

    public Condition setDate(String date) {
        this.date = date;
        return  this;
    }

    @Override
    public String toString() {
        return "Condition{" +
                " cid=" + cid +
                ", lid=" + lid +
                ", date='" + date + '\'' +
                '}';
    }
}
