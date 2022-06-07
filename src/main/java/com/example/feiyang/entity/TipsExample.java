package com.example.feiyang.entity;

import java.util.ArrayList;
import java.util.List;

public class TipsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TipsExample() {
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

        public Criteria andIsPopIsNull() {
            addCriterion("is_pop is null");
            return (Criteria) this;
        }

        public Criteria andIsPopIsNotNull() {
            addCriterion("is_pop is not null");
            return (Criteria) this;
        }

        public Criteria andIsPopEqualTo(Integer value) {
            addCriterion("is_pop =", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopNotEqualTo(Integer value) {
            addCriterion("is_pop <>", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopGreaterThan(Integer value) {
            addCriterion("is_pop >", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pop >=", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopLessThan(Integer value) {
            addCriterion("is_pop <", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopLessThanOrEqualTo(Integer value) {
            addCriterion("is_pop <=", value, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopIn(List<Integer> values) {
            addCriterion("is_pop in", values, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopNotIn(List<Integer> values) {
            addCriterion("is_pop not in", values, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopBetween(Integer value1, Integer value2) {
            addCriterion("is_pop between", value1, value2, "isPop");
            return (Criteria) this;
        }

        public Criteria andIsPopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pop not between", value1, value2, "isPop");
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