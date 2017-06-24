package com.hang.blog.mvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccessRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME_ is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("STARTTIME_ =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("STARTTIME_ <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("STARTTIME_ >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STARTTIME_ >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("STARTTIME_ <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("STARTTIME_ <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("STARTTIME_ in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("STARTTIME_ not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("STARTTIME_ between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("STARTTIME_ not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME_ is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("ENDTIME_ =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("ENDTIME_ <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("ENDTIME_ >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENDTIME_ >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("ENDTIME_ <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("ENDTIME_ <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("ENDTIME_ in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("ENDTIME_ not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("ENDTIME_ between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("ENDTIME_ not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andMillisecondIsNull() {
            addCriterion("MILLISECOND_ is null");
            return (Criteria) this;
        }

        public Criteria andMillisecondIsNotNull() {
            addCriterion("MILLISECOND_ is not null");
            return (Criteria) this;
        }

        public Criteria andMillisecondEqualTo(Integer value) {
            addCriterion("MILLISECOND_ =", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotEqualTo(Integer value) {
            addCriterion("MILLISECOND_ <>", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondGreaterThan(Integer value) {
            addCriterion("MILLISECOND_ >", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondGreaterThanOrEqualTo(Integer value) {
            addCriterion("MILLISECOND_ >=", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondLessThan(Integer value) {
            addCriterion("MILLISECOND_ <", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondLessThanOrEqualTo(Integer value) {
            addCriterion("MILLISECOND_ <=", value, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondIn(List<Integer> values) {
            addCriterion("MILLISECOND_ in", values, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotIn(List<Integer> values) {
            addCriterion("MILLISECOND_ not in", values, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondBetween(Integer value1, Integer value2) {
            addCriterion("MILLISECOND_ between", value1, value2, "millisecond");
            return (Criteria) this;
        }

        public Criteria andMillisecondNotBetween(Integer value1, Integer value2) {
            addCriterion("MILLISECOND_ not between", value1, value2, "millisecond");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("COOKIE_ is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("COOKIE_ is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("COOKIE_ =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("COOKIE_ <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("COOKIE_ >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("COOKIE_ >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("COOKIE_ <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("COOKIE_ <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("COOKIE_ like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("COOKIE_ not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("COOKIE_ in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("COOKIE_ not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("COOKIE_ between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("COOKIE_ not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNull() {
            addCriterion("USERAGENT_ is null");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNotNull() {
            addCriterion("USERAGENT_ is not null");
            return (Criteria) this;
        }

        public Criteria andUseragentEqualTo(String value) {
            addCriterion("USERAGENT_ =", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotEqualTo(String value) {
            addCriterion("USERAGENT_ <>", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThan(String value) {
            addCriterion("USERAGENT_ >", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThanOrEqualTo(String value) {
            addCriterion("USERAGENT_ >=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThan(String value) {
            addCriterion("USERAGENT_ <", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThanOrEqualTo(String value) {
            addCriterion("USERAGENT_ <=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLike(String value) {
            addCriterion("USERAGENT_ like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotLike(String value) {
            addCriterion("USERAGENT_ not like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentIn(List<String> values) {
            addCriterion("USERAGENT_ in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotIn(List<String> values) {
            addCriterion("USERAGENT_ not in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentBetween(String value1, String value2) {
            addCriterion("USERAGENT_ between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotBetween(String value1, String value2) {
            addCriterion("USERAGENT_ not between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andIpsIsNull() {
            addCriterion("IPS_ is null");
            return (Criteria) this;
        }

        public Criteria andIpsIsNotNull() {
            addCriterion("IPS_ is not null");
            return (Criteria) this;
        }

        public Criteria andIpsEqualTo(String value) {
            addCriterion("IPS_ =", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotEqualTo(String value) {
            addCriterion("IPS_ <>", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThan(String value) {
            addCriterion("IPS_ >", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThanOrEqualTo(String value) {
            addCriterion("IPS_ >=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThan(String value) {
            addCriterion("IPS_ <", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThanOrEqualTo(String value) {
            addCriterion("IPS_ <=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLike(String value) {
            addCriterion("IPS_ like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotLike(String value) {
            addCriterion("IPS_ not like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsIn(List<String> values) {
            addCriterion("IPS_ in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotIn(List<String> values) {
            addCriterion("IPS_ not in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsBetween(String value1, String value2) {
            addCriterion("IPS_ between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotBetween(String value1, String value2) {
            addCriterion("IPS_ not between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("METHOD_ is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("METHOD_ is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("METHOD_ =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("METHOD_ <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("METHOD_ >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("METHOD_ >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("METHOD_ <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("METHOD_ <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("METHOD_ like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("METHOD_ not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("METHOD_ in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("METHOD_ not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("METHOD_ between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("METHOD_ not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRefererIsNull() {
            addCriterion("REFERER_ is null");
            return (Criteria) this;
        }

        public Criteria andRefererIsNotNull() {
            addCriterion("REFERER_ is not null");
            return (Criteria) this;
        }

        public Criteria andRefererEqualTo(String value) {
            addCriterion("REFERER_ =", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotEqualTo(String value) {
            addCriterion("REFERER_ <>", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThan(String value) {
            addCriterion("REFERER_ >", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThanOrEqualTo(String value) {
            addCriterion("REFERER_ >=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThan(String value) {
            addCriterion("REFERER_ <", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThanOrEqualTo(String value) {
            addCriterion("REFERER_ <=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLike(String value) {
            addCriterion("REFERER_ like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotLike(String value) {
            addCriterion("REFERER_ not like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererIn(List<String> values) {
            addCriterion("REFERER_ in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotIn(List<String> values) {
            addCriterion("REFERER_ not in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererBetween(String value1, String value2) {
            addCriterion("REFERER_ between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotBetween(String value1, String value2) {
            addCriterion("REFERER_ not between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNull() {
            addCriterion("ACCEPT_ is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNotNull() {
            addCriterion("ACCEPT_ is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEqualTo(String value) {
            addCriterion("ACCEPT_ =", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotEqualTo(String value) {
            addCriterion("ACCEPT_ <>", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThan(String value) {
            addCriterion("ACCEPT_ >", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_ >=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThan(String value) {
            addCriterion("ACCEPT_ <", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_ <=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLike(String value) {
            addCriterion("ACCEPT_ like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotLike(String value) {
            addCriterion("ACCEPT_ not like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptIn(List<String> values) {
            addCriterion("ACCEPT_ in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotIn(List<String> values) {
            addCriterion("ACCEPT_ not in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptBetween(String value1, String value2) {
            addCriterion("ACCEPT_ between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_ not between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIsNull() {
            addCriterion("ACCEPTENCODING_ is null");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIsNotNull() {
            addCriterion("ACCEPTENCODING_ is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingEqualTo(String value) {
            addCriterion("ACCEPTENCODING_ =", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotEqualTo(String value) {
            addCriterion("ACCEPTENCODING_ <>", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingGreaterThan(String value) {
            addCriterion("ACCEPTENCODING_ >", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTENCODING_ >=", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLessThan(String value) {
            addCriterion("ACCEPTENCODING_ <", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTENCODING_ <=", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLike(String value) {
            addCriterion("ACCEPTENCODING_ like", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotLike(String value) {
            addCriterion("ACCEPTENCODING_ not like", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIn(List<String> values) {
            addCriterion("ACCEPTENCODING_ in", values, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotIn(List<String> values) {
            addCriterion("ACCEPTENCODING_ not in", values, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingBetween(String value1, String value2) {
            addCriterion("ACCEPTENCODING_ between", value1, value2, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotBetween(String value1, String value2) {
            addCriterion("ACCEPTENCODING_ not between", value1, value2, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIsNull() {
            addCriterion("ACCEPTLANGUAGE_ is null");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIsNotNull() {
            addCriterion("ACCEPTLANGUAGE_ is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageEqualTo(String value) {
            addCriterion("ACCEPTLANGUAGE_ =", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotEqualTo(String value) {
            addCriterion("ACCEPTLANGUAGE_ <>", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageGreaterThan(String value) {
            addCriterion("ACCEPTLANGUAGE_ >", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPTLANGUAGE_ >=", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLessThan(String value) {
            addCriterion("ACCEPTLANGUAGE_ <", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLessThanOrEqualTo(String value) {
            addCriterion("ACCEPTLANGUAGE_ <=", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLike(String value) {
            addCriterion("ACCEPTLANGUAGE_ like", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotLike(String value) {
            addCriterion("ACCEPTLANGUAGE_ not like", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIn(List<String> values) {
            addCriterion("ACCEPTLANGUAGE_ in", values, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotIn(List<String> values) {
            addCriterion("ACCEPTLANGUAGE_ not in", values, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageBetween(String value1, String value2) {
            addCriterion("ACCEPTLANGUAGE_ between", value1, value2, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotBetween(String value1, String value2) {
            addCriterion("ACCEPTLANGUAGE_ not between", value1, value2, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNull() {
            addCriterion("CONNECTION_ is null");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNotNull() {
            addCriterion("CONNECTION_ is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionEqualTo(String value) {
            addCriterion("CONNECTION_ =", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotEqualTo(String value) {
            addCriterion("CONNECTION_ <>", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThan(String value) {
            addCriterion("CONNECTION_ >", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThanOrEqualTo(String value) {
            addCriterion("CONNECTION_ >=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThan(String value) {
            addCriterion("CONNECTION_ <", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThanOrEqualTo(String value) {
            addCriterion("CONNECTION_ <=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLike(String value) {
            addCriterion("CONNECTION_ like", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotLike(String value) {
            addCriterion("CONNECTION_ not like", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionIn(List<String> values) {
            addCriterion("CONNECTION_ in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotIn(List<String> values) {
            addCriterion("CONNECTION_ not in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionBetween(String value1, String value2) {
            addCriterion("CONNECTION_ between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotBetween(String value1, String value2) {
            addCriterion("CONNECTION_ not between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("HOST_ is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("HOST_ is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("HOST_ =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("HOST_ <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("HOST_ >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("HOST_ >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("HOST_ <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("HOST_ <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("HOST_ like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("HOST_ not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("HOST_ in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("HOST_ not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("HOST_ between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("HOST_ not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIsNull() {
            addCriterion("XREQUESTEDWITH_ is null");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIsNotNull() {
            addCriterion("XREQUESTEDWITH_ is not null");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithEqualTo(String value) {
            addCriterion("XREQUESTEDWITH_ =", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotEqualTo(String value) {
            addCriterion("XREQUESTEDWITH_ <>", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithGreaterThan(String value) {
            addCriterion("XREQUESTEDWITH_ >", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithGreaterThanOrEqualTo(String value) {
            addCriterion("XREQUESTEDWITH_ >=", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLessThan(String value) {
            addCriterion("XREQUESTEDWITH_ <", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLessThanOrEqualTo(String value) {
            addCriterion("XREQUESTEDWITH_ <=", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLike(String value) {
            addCriterion("XREQUESTEDWITH_ like", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotLike(String value) {
            addCriterion("XREQUESTEDWITH_ not like", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIn(List<String> values) {
            addCriterion("XREQUESTEDWITH_ in", values, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotIn(List<String> values) {
            addCriterion("XREQUESTEDWITH_ not in", values, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithBetween(String value1, String value2) {
            addCriterion("XREQUESTEDWITH_ between", value1, value2, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotBetween(String value1, String value2) {
            addCriterion("XREQUESTEDWITH_ not between", value1, value2, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}