package com.hang.blog.mvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrendLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FrendLinkExample() {
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME_ is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME_ =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME_ <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME_ >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME_ >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME_ <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME_ <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME_ in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME_ not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME_ between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME_ not between", value1, value2, "createtime");
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

        public Criteria andLinkIsNull() {
            addCriterion("LINK_ is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("LINK_ is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("LINK_ =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("LINK_ <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("LINK_ >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_ >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("LINK_ <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("LINK_ <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("LINK_ like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("LINK_ not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("LINK_ in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("LINK_ not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("LINK_ between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("LINK_ not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinktitleIsNull() {
            addCriterion("LINKTITLE_ is null");
            return (Criteria) this;
        }

        public Criteria andLinktitleIsNotNull() {
            addCriterion("LINKTITLE_ is not null");
            return (Criteria) this;
        }

        public Criteria andLinktitleEqualTo(String value) {
            addCriterion("LINKTITLE_ =", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleNotEqualTo(String value) {
            addCriterion("LINKTITLE_ <>", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleGreaterThan(String value) {
            addCriterion("LINKTITLE_ >", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleGreaterThanOrEqualTo(String value) {
            addCriterion("LINKTITLE_ >=", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleLessThan(String value) {
            addCriterion("LINKTITLE_ <", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleLessThanOrEqualTo(String value) {
            addCriterion("LINKTITLE_ <=", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleLike(String value) {
            addCriterion("LINKTITLE_ like", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleNotLike(String value) {
            addCriterion("LINKTITLE_ not like", value, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleIn(List<String> values) {
            addCriterion("LINKTITLE_ in", values, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleNotIn(List<String> values) {
            addCriterion("LINKTITLE_ not in", values, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleBetween(String value1, String value2) {
            addCriterion("LINKTITLE_ between", value1, value2, "linktitle");
            return (Criteria) this;
        }

        public Criteria andLinktitleNotBetween(String value1, String value2) {
            addCriterion("LINKTITLE_ not between", value1, value2, "linktitle");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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