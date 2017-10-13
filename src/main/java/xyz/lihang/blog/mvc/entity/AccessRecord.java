package xyz.lihang.blog.mvc.entity;

import java.io.Serializable;
import java.util.Date;

public class AccessRecord implements Serializable{
    

	private String id;

    private Date starttime;

    private Date endtime;

    private Integer millisecond;

    private String cookie;

    private String useragent;

    private String ips;

    private String method;

    private String referer;

    private String accept;

    private String acceptencoding;

    private String acceptlanguage;

    private String connection;

    private String host;

    private String xrequestedwith;

    private String userid;

    private String requestpath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(Integer millisecond) {
        this.millisecond = millisecond;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips == null ? null : ips.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept == null ? null : accept.trim();
    }

    public String getAcceptencoding() {
        return acceptencoding;
    }

    public void setAcceptencoding(String acceptencoding) {
        this.acceptencoding = acceptencoding == null ? null : acceptencoding.trim();
    }

    public String getAcceptlanguage() {
        return acceptlanguage;
    }

    public void setAcceptlanguage(String acceptlanguage) {
        this.acceptlanguage = acceptlanguage == null ? null : acceptlanguage.trim();
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection == null ? null : connection.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getXrequestedwith() {
        return xrequestedwith;
    }

    public void setXrequestedwith(String xrequestedwith) {
        this.xrequestedwith = xrequestedwith == null ? null : xrequestedwith.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRequestpath() {
        return requestpath;
    }

    public void setRequestpath(String requestpath) {
        this.requestpath = requestpath == null ? null : requestpath.trim();
    }
    
    @Override
	public String toString() {
		return "AccessRecord [id=" + id + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", millisecond=" + millisecond
				+ ", cookie=" + cookie + ", useragent=" + useragent + ", ips="
				+ ips + ", method=" + method + ", referer=" + referer
				+ ", accept=" + accept + ", acceptencoding=" + acceptencoding
				+ ", acceptlanguage=" + acceptlanguage + ", connection="
				+ connection + ", host=" + host + ", xrequestedwith="
				+ xrequestedwith + ", userid=" + userid + ", requestpath="
				+ requestpath + "]";
	}
    
}