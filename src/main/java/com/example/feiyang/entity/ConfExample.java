package com.example.feiyang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfExample() {
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

        public Criteria andGlobalFlagIsNull() {
            addCriterion("global_flag is null");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagIsNotNull() {
            addCriterion("global_flag is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagEqualTo(Integer value) {
            addCriterion("global_flag =", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagNotEqualTo(Integer value) {
            addCriterion("global_flag <>", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagGreaterThan(Integer value) {
            addCriterion("global_flag >", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("global_flag >=", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagLessThan(Integer value) {
            addCriterion("global_flag <", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagLessThanOrEqualTo(Integer value) {
            addCriterion("global_flag <=", value, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagIn(List<Integer> values) {
            addCriterion("global_flag in", values, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagNotIn(List<Integer> values) {
            addCriterion("global_flag not in", values, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagBetween(Integer value1, Integer value2) {
            addCriterion("global_flag between", value1, value2, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("global_flag not between", value1, value2, "globalFlag");
            return (Criteria) this;
        }

        public Criteria andGlobalYearIsNull() {
            addCriterion("global_year is null");
            return (Criteria) this;
        }

        public Criteria andGlobalYearIsNotNull() {
            addCriterion("global_year is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalYearEqualTo(Integer value) {
            addCriterion("global_year =", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearNotEqualTo(Integer value) {
            addCriterion("global_year <>", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearGreaterThan(Integer value) {
            addCriterion("global_year >", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("global_year >=", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearLessThan(Integer value) {
            addCriterion("global_year <", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearLessThanOrEqualTo(Integer value) {
            addCriterion("global_year <=", value, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearIn(List<Integer> values) {
            addCriterion("global_year in", values, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearNotIn(List<Integer> values) {
            addCriterion("global_year not in", values, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearBetween(Integer value1, Integer value2) {
            addCriterion("global_year between", value1, value2, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalYearNotBetween(Integer value1, Integer value2) {
            addCriterion("global_year not between", value1, value2, "globalYear");
            return (Criteria) this;
        }

        public Criteria andGlobalDayIsNull() {
            addCriterion("global_day is null");
            return (Criteria) this;
        }

        public Criteria andGlobalDayIsNotNull() {
            addCriterion("global_day is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalDayEqualTo(Integer value) {
            addCriterion("global_day =", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayNotEqualTo(Integer value) {
            addCriterion("global_day <>", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayGreaterThan(Integer value) {
            addCriterion("global_day >", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("global_day >=", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayLessThan(Integer value) {
            addCriterion("global_day <", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayLessThanOrEqualTo(Integer value) {
            addCriterion("global_day <=", value, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayIn(List<Integer> values) {
            addCriterion("global_day in", values, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayNotIn(List<Integer> values) {
            addCriterion("global_day not in", values, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayBetween(Integer value1, Integer value2) {
            addCriterion("global_day between", value1, value2, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalDayNotBetween(Integer value1, Integer value2) {
            addCriterion("global_day not between", value1, value2, "globalDay");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekIsNull() {
            addCriterion("global_week is null");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekIsNotNull() {
            addCriterion("global_week is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekEqualTo(Integer value) {
            addCriterion("global_week =", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekNotEqualTo(Integer value) {
            addCriterion("global_week <>", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekGreaterThan(Integer value) {
            addCriterion("global_week >", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("global_week >=", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekLessThan(Integer value) {
            addCriterion("global_week <", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekLessThanOrEqualTo(Integer value) {
            addCriterion("global_week <=", value, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekIn(List<Integer> values) {
            addCriterion("global_week in", values, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekNotIn(List<Integer> values) {
            addCriterion("global_week not in", values, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekBetween(Integer value1, Integer value2) {
            addCriterion("global_week between", value1, value2, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("global_week not between", value1, value2, "globalWeek");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthIsNull() {
            addCriterion("global_month is null");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthIsNotNull() {
            addCriterion("global_month is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthEqualTo(Integer value) {
            addCriterion("global_month =", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthNotEqualTo(Integer value) {
            addCriterion("global_month <>", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthGreaterThan(Integer value) {
            addCriterion("global_month >", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("global_month >=", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthLessThan(Integer value) {
            addCriterion("global_month <", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthLessThanOrEqualTo(Integer value) {
            addCriterion("global_month <=", value, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthIn(List<Integer> values) {
            addCriterion("global_month in", values, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthNotIn(List<Integer> values) {
            addCriterion("global_month not in", values, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthBetween(Integer value1, Integer value2) {
            addCriterion("global_month between", value1, value2, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("global_month not between", value1, value2, "globalMonth");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeIsNull() {
            addCriterion("global_time is null");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeIsNotNull() {
            addCriterion("global_time is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeEqualTo(Date value) {
            addCriterion("global_time =", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeNotEqualTo(Date value) {
            addCriterion("global_time <>", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeGreaterThan(Date value) {
            addCriterion("global_time >", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("global_time >=", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeLessThan(Date value) {
            addCriterion("global_time <", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeLessThanOrEqualTo(Date value) {
            addCriterion("global_time <=", value, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeIn(List<Date> values) {
            addCriterion("global_time in", values, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeNotIn(List<Date> values) {
            addCriterion("global_time not in", values, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeBetween(Date value1, Date value2) {
            addCriterion("global_time between", value1, value2, "globalTime");
            return (Criteria) this;
        }

        public Criteria andGlobalTimeNotBetween(Date value1, Date value2) {
            addCriterion("global_time not between", value1, value2, "globalTime");
            return (Criteria) this;
        }

        public Criteria andLimitDayIsNull() {
            addCriterion("limit_day is null");
            return (Criteria) this;
        }

        public Criteria andLimitDayIsNotNull() {
            addCriterion("limit_day is not null");
            return (Criteria) this;
        }

        public Criteria andLimitDayEqualTo(Integer value) {
            addCriterion("limit_day =", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotEqualTo(Integer value) {
            addCriterion("limit_day <>", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayGreaterThan(Integer value) {
            addCriterion("limit_day >", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_day >=", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayLessThan(Integer value) {
            addCriterion("limit_day <", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayLessThanOrEqualTo(Integer value) {
            addCriterion("limit_day <=", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayIn(List<Integer> values) {
            addCriterion("limit_day in", values, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotIn(List<Integer> values) {
            addCriterion("limit_day not in", values, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayBetween(Integer value1, Integer value2) {
            addCriterion("limit_day between", value1, value2, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_day not between", value1, value2, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitWeekIsNull() {
            addCriterion("limit_week is null");
            return (Criteria) this;
        }

        public Criteria andLimitWeekIsNotNull() {
            addCriterion("limit_week is not null");
            return (Criteria) this;
        }

        public Criteria andLimitWeekEqualTo(Integer value) {
            addCriterion("limit_week =", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekNotEqualTo(Integer value) {
            addCriterion("limit_week <>", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekGreaterThan(Integer value) {
            addCriterion("limit_week >", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_week >=", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekLessThan(Integer value) {
            addCriterion("limit_week <", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekLessThanOrEqualTo(Integer value) {
            addCriterion("limit_week <=", value, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekIn(List<Integer> values) {
            addCriterion("limit_week in", values, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekNotIn(List<Integer> values) {
            addCriterion("limit_week not in", values, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekBetween(Integer value1, Integer value2) {
            addCriterion("limit_week between", value1, value2, "limitWeek");
            return (Criteria) this;
        }

        public Criteria andLimitWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_week not between", value1, value2, "limitWeek");
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