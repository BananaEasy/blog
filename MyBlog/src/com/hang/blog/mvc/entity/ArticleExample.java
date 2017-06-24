package com.hang.blog.mvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNull() {
            addCriterion("LABEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("LABEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(Integer value) {
            addCriterion("LABEL_ID =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(Integer value) {
            addCriterion("LABEL_ID <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(Integer value) {
            addCriterion("LABEL_ID >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LABEL_ID >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(Integer value) {
            addCriterion("LABEL_ID <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("LABEL_ID <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<Integer> values) {
            addCriterion("LABEL_ID in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<Integer> values) {
            addCriterion("LABEL_ID not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("LABEL_ID between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LABEL_ID not between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("CATEGORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("CATEGORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("CATEGORY_ID =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("CATEGORY_ID >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("CATEGORY_ID <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("CATEGORY_ID in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("CATEGORY_ID not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andArticleusernameIsNull() {
            addCriterion("ARTICLEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andArticleusernameIsNotNull() {
            addCriterion("ARTICLEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andArticleusernameEqualTo(String value) {
            addCriterion("ARTICLEUSERNAME =", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameNotEqualTo(String value) {
            addCriterion("ARTICLEUSERNAME <>", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameGreaterThan(String value) {
            addCriterion("ARTICLEUSERNAME >", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLEUSERNAME >=", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameLessThan(String value) {
            addCriterion("ARTICLEUSERNAME <", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameLessThanOrEqualTo(String value) {
            addCriterion("ARTICLEUSERNAME <=", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameLike(String value) {
            addCriterion("ARTICLEUSERNAME like", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameNotLike(String value) {
            addCriterion("ARTICLEUSERNAME not like", value, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameIn(List<String> values) {
            addCriterion("ARTICLEUSERNAME in", values, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameNotIn(List<String> values) {
            addCriterion("ARTICLEUSERNAME not in", values, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameBetween(String value1, String value2) {
            addCriterion("ARTICLEUSERNAME between", value1, value2, "articleusername");
            return (Criteria) this;
        }

        public Criteria andArticleusernameNotBetween(String value1, String value2) {
            addCriterion("ARTICLEUSERNAME not between", value1, value2, "articleusername");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNull() {
            addCriterion("ARTICLETITLE is null");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNotNull() {
            addCriterion("ARTICLETITLE is not null");
            return (Criteria) this;
        }

        public Criteria andArticletitleEqualTo(String value) {
            addCriterion("ARTICLETITLE =", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotEqualTo(String value) {
            addCriterion("ARTICLETITLE <>", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThan(String value) {
            addCriterion("ARTICLETITLE >", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLE >=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThan(String value) {
            addCriterion("ARTICLETITLE <", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLE <=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLike(String value) {
            addCriterion("ARTICLETITLE like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotLike(String value) {
            addCriterion("ARTICLETITLE not like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleIn(List<String> values) {
            addCriterion("ARTICLETITLE in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotIn(List<String> values) {
            addCriterion("ARTICLETITLE not in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleBetween(String value1, String value2) {
            addCriterion("ARTICLETITLE between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotBetween(String value1, String value2) {
            addCriterion("ARTICLETITLE not between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticlehrefIsNull() {
            addCriterion("ARTICLEHREF is null");
            return (Criteria) this;
        }

        public Criteria andArticlehrefIsNotNull() {
            addCriterion("ARTICLEHREF is not null");
            return (Criteria) this;
        }

        public Criteria andArticlehrefEqualTo(String value) {
            addCriterion("ARTICLEHREF =", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefNotEqualTo(String value) {
            addCriterion("ARTICLEHREF <>", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefGreaterThan(String value) {
            addCriterion("ARTICLEHREF >", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLEHREF >=", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefLessThan(String value) {
            addCriterion("ARTICLEHREF <", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefLessThanOrEqualTo(String value) {
            addCriterion("ARTICLEHREF <=", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefLike(String value) {
            addCriterion("ARTICLEHREF like", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefNotLike(String value) {
            addCriterion("ARTICLEHREF not like", value, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefIn(List<String> values) {
            addCriterion("ARTICLEHREF in", values, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefNotIn(List<String> values) {
            addCriterion("ARTICLEHREF not in", values, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefBetween(String value1, String value2) {
            addCriterion("ARTICLEHREF between", value1, value2, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehrefNotBetween(String value1, String value2) {
            addCriterion("ARTICLEHREF not between", value1, value2, "articlehref");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleIsNull() {
            addCriterion("ARTICLEHREFTITLE is null");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleIsNotNull() {
            addCriterion("ARTICLEHREFTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleEqualTo(String value) {
            addCriterion("ARTICLEHREFTITLE =", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleNotEqualTo(String value) {
            addCriterion("ARTICLEHREFTITLE <>", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleGreaterThan(String value) {
            addCriterion("ARTICLEHREFTITLE >", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLEHREFTITLE >=", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleLessThan(String value) {
            addCriterion("ARTICLEHREFTITLE <", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleLessThanOrEqualTo(String value) {
            addCriterion("ARTICLEHREFTITLE <=", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleLike(String value) {
            addCriterion("ARTICLEHREFTITLE like", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleNotLike(String value) {
            addCriterion("ARTICLEHREFTITLE not like", value, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleIn(List<String> values) {
            addCriterion("ARTICLEHREFTITLE in", values, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleNotIn(List<String> values) {
            addCriterion("ARTICLEHREFTITLE not in", values, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleBetween(String value1, String value2) {
            addCriterion("ARTICLEHREFTITLE between", value1, value2, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andArticlehreftitleNotBetween(String value1, String value2) {
            addCriterion("ARTICLEHREFTITLE not between", value1, value2, "articlehreftitle");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Long value) {
            addCriterion("COUNT_ =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Long value) {
            addCriterion("COUNT_ <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Long value) {
            addCriterion("COUNT_ >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Long value) {
            addCriterion("COUNT_ >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Long value) {
            addCriterion("COUNT_ <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Long value) {
            addCriterion("COUNT_ <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Long> values) {
            addCriterion("COUNT_ in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Long> values) {
            addCriterion("COUNT_ not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Long value1, Long value2) {
            addCriterion("COUNT_ between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Long value1, Long value2) {
            addCriterion("COUNT_ not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andTopIsNull() {
            addCriterion("TOP_ is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("TOP_ is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(Integer value) {
            addCriterion("TOP_ =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(Integer value) {
            addCriterion("TOP_ <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(Integer value) {
            addCriterion("TOP_ >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOP_ >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(Integer value) {
            addCriterion("TOP_ <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(Integer value) {
            addCriterion("TOP_ <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<Integer> values) {
            addCriterion("TOP_ in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<Integer> values) {
            addCriterion("TOP_ not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(Integer value1, Integer value2) {
            addCriterion("TOP_ between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(Integer value1, Integer value2) {
            addCriterion("TOP_ not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION_ is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION_ is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION_ =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION_ <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION_ >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION_ >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION_ <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION_ <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION_ in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION_ not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION_ between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION_ not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIsoriginalIsNull() {
            addCriterion("ISORIGINAL_ is null");
            return (Criteria) this;
        }

        public Criteria andIsoriginalIsNotNull() {
            addCriterion("ISORIGINAL_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsoriginalEqualTo(Integer value) {
            addCriterion("ISORIGINAL_ =", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalNotEqualTo(Integer value) {
            addCriterion("ISORIGINAL_ <>", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalGreaterThan(Integer value) {
            addCriterion("ISORIGINAL_ >", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISORIGINAL_ >=", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalLessThan(Integer value) {
            addCriterion("ISORIGINAL_ <", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalLessThanOrEqualTo(Integer value) {
            addCriterion("ISORIGINAL_ <=", value, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalIn(List<Integer> values) {
            addCriterion("ISORIGINAL_ in", values, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalNotIn(List<Integer> values) {
            addCriterion("ISORIGINAL_ not in", values, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalBetween(Integer value1, Integer value2) {
            addCriterion("ISORIGINAL_ between", value1, value2, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andIsoriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("ISORIGINAL_ not between", value1, value2, "isoriginal");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1IsNull() {
            addCriterion("ARTICLETITLEIMAGEPATH1 is null");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1IsNotNull() {
            addCriterion("ARTICLETITLEIMAGEPATH1 is not null");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1EqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 =", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1NotEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 <>", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1GreaterThan(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 >", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1GreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 >=", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1LessThan(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 <", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1LessThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 <=", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1Like(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 like", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1NotLike(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH1 not like", value, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1In(List<String> values) {
            addCriterion("ARTICLETITLEIMAGEPATH1 in", values, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1NotIn(List<String> values) {
            addCriterion("ARTICLETITLEIMAGEPATH1 not in", values, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1Between(String value1, String value2) {
            addCriterion("ARTICLETITLEIMAGEPATH1 between", value1, value2, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath1NotBetween(String value1, String value2) {
            addCriterion("ARTICLETITLEIMAGEPATH1 not between", value1, value2, "articletitleimagepath1");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2IsNull() {
            addCriterion("ARTICLETITLEIMAGEPATH2 is null");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2IsNotNull() {
            addCriterion("ARTICLETITLEIMAGEPATH2 is not null");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2EqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 =", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2NotEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 <>", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2GreaterThan(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 >", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2GreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 >=", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2LessThan(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 <", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2LessThanOrEqualTo(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 <=", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2Like(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 like", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2NotLike(String value) {
            addCriterion("ARTICLETITLEIMAGEPATH2 not like", value, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2In(List<String> values) {
            addCriterion("ARTICLETITLEIMAGEPATH2 in", values, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2NotIn(List<String> values) {
            addCriterion("ARTICLETITLEIMAGEPATH2 not in", values, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2Between(String value1, String value2) {
            addCriterion("ARTICLETITLEIMAGEPATH2 between", value1, value2, "articletitleimagepath2");
            return (Criteria) this;
        }

        public Criteria andArticletitleimagepath2NotBetween(String value1, String value2) {
            addCriterion("ARTICLETITLEIMAGEPATH2 not between", value1, value2, "articletitleimagepath2");
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