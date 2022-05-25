package com.example.feiyang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRepairCountIsNull() {
            addCriterion("repair_count is null");
            return (Criteria) this;
        }

        public Criteria andRepairCountIsNotNull() {
            addCriterion("repair_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepairCountEqualTo(Integer value) {
            addCriterion("repair_count =", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountNotEqualTo(Integer value) {
            addCriterion("repair_count <>", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountGreaterThan(Integer value) {
            addCriterion("repair_count >", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_count >=", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountLessThan(Integer value) {
            addCriterion("repair_count <", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountLessThanOrEqualTo(Integer value) {
            addCriterion("repair_count <=", value, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountIn(List<Integer> values) {
            addCriterion("repair_count in", values, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountNotIn(List<Integer> values) {
            addCriterion("repair_count not in", values, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountBetween(Integer value1, Integer value2) {
            addCriterion("repair_count between", value1, value2, "repairCount");
            return (Criteria) this;
        }

        public Criteria andRepairCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_count not between", value1, value2, "repairCount");
            return (Criteria) this;
        }

        public Criteria andPostCountIsNull() {
            addCriterion("post_count is null");
            return (Criteria) this;
        }

        public Criteria andPostCountIsNotNull() {
            addCriterion("post_count is not null");
            return (Criteria) this;
        }

        public Criteria andPostCountEqualTo(Integer value) {
            addCriterion("post_count =", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountNotEqualTo(Integer value) {
            addCriterion("post_count <>", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountGreaterThan(Integer value) {
            addCriterion("post_count >", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_count >=", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountLessThan(Integer value) {
            addCriterion("post_count <", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountLessThanOrEqualTo(Integer value) {
            addCriterion("post_count <=", value, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountIn(List<Integer> values) {
            addCriterion("post_count in", values, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountNotIn(List<Integer> values) {
            addCriterion("post_count not in", values, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountBetween(Integer value1, Integer value2) {
            addCriterion("post_count between", value1, value2, "postCount");
            return (Criteria) this;
        }

        public Criteria andPostCountNotBetween(Integer value1, Integer value2) {
            addCriterion("post_count not between", value1, value2, "postCount");
            return (Criteria) this;
        }

        public Criteria andIsAllowIsNull() {
            addCriterion("is_allow is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowIsNotNull() {
            addCriterion("is_allow is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowEqualTo(Integer value) {
            addCriterion("is_allow =", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowNotEqualTo(Integer value) {
            addCriterion("is_allow <>", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowGreaterThan(Integer value) {
            addCriterion("is_allow >", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_allow >=", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowLessThan(Integer value) {
            addCriterion("is_allow <", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowLessThanOrEqualTo(Integer value) {
            addCriterion("is_allow <=", value, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowIn(List<Integer> values) {
            addCriterion("is_allow in", values, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowNotIn(List<Integer> values) {
            addCriterion("is_allow not in", values, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowBetween(Integer value1, Integer value2) {
            addCriterion("is_allow between", value1, value2, "isAllow");
            return (Criteria) this;
        }

        public Criteria andIsAllowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_allow not between", value1, value2, "isAllow");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(Date value) {
            addCriterion("last_time =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(Date value) {
            addCriterion("last_time <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(Date value) {
            addCriterion("last_time >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_time >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(Date value) {
            addCriterion("last_time <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_time <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<Date> values) {
            addCriterion("last_time in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<Date> values) {
            addCriterion("last_time not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(Date value1, Date value2) {
            addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_time not between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalIsNull() {
            addCriterion("receive_interval is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalIsNotNull() {
            addCriterion("receive_interval is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalEqualTo(Integer value) {
            addCriterion("receive_interval =", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalNotEqualTo(Integer value) {
            addCriterion("receive_interval <>", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalGreaterThan(Integer value) {
            addCriterion("receive_interval >", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_interval >=", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalLessThan(Integer value) {
            addCriterion("receive_interval <", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("receive_interval <=", value, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalIn(List<Integer> values) {
            addCriterion("receive_interval in", values, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalNotIn(List<Integer> values) {
            addCriterion("receive_interval not in", values, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalBetween(Integer value1, Integer value2) {
            addCriterion("receive_interval between", value1, value2, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andReceiveIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_interval not between", value1, value2, "receiveInterval");
            return (Criteria) this;
        }

        public Criteria andOrderTransferIsNull() {
            addCriterion("order_transfer is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransferIsNotNull() {
            addCriterion("order_transfer is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransferEqualTo(Integer value) {
            addCriterion("order_transfer =", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferNotEqualTo(Integer value) {
            addCriterion("order_transfer <>", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferGreaterThan(Integer value) {
            addCriterion("order_transfer >", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_transfer >=", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferLessThan(Integer value) {
            addCriterion("order_transfer <", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferLessThanOrEqualTo(Integer value) {
            addCriterion("order_transfer <=", value, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferIn(List<Integer> values) {
            addCriterion("order_transfer in", values, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferNotIn(List<Integer> values) {
            addCriterion("order_transfer not in", values, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferBetween(Integer value1, Integer value2) {
            addCriterion("order_transfer between", value1, value2, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andOrderTransferNotBetween(Integer value1, Integer value2) {
            addCriterion("order_transfer not between", value1, value2, "orderTransfer");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNull() {
            addCriterion("next_time is null");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNotNull() {
            addCriterion("next_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextTimeEqualTo(Date value) {
            addCriterion("next_time =", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotEqualTo(Date value) {
            addCriterion("next_time <>", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThan(Date value) {
            addCriterion("next_time >", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_time >=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThan(Date value) {
            addCriterion("next_time <", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_time <=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeIn(List<Date> values) {
            addCriterion("next_time in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotIn(List<Date> values) {
            addCriterion("next_time not in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeBetween(Date value1, Date value2) {
            addCriterion("next_time between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_time not between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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