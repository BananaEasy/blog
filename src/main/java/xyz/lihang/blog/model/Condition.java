package xyz.lihang.blog.model;

/**
 * Created by LiHang on 2017/8/7.
 */
public class Condition {

    private String search;

    //类别id
    private Integer cid;

    //标签Id
    private Integer lid;


    private String date;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "search='" + search + '\'' +
                ", cid=" + cid +
                ", lid=" + lid +
                ", date='" + date + '\'' +
                '}';
    }
}
