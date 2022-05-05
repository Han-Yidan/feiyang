package com.example.feiyang.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
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

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Long value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Long value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Long value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Long value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Long value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Long> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Long> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Long value1, Long value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Long value1, Long value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNull() {
            addCriterion("buy_time is null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIsNotNull() {
            addCriterion("buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTimeEqualTo(Date value) {
            addCriterion("buy_time =", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotEqualTo(Date value) {
            addCriterion("buy_time <>", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThan(Date value) {
            addCriterion("buy_time >", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("buy_time >=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThan(Date value) {
            addCriterion("buy_time <", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeLessThanOrEqualTo(Date value) {
            addCriterion("buy_time <=", value, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeIn(List<Date> values) {
            addCriterion("buy_time in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotIn(List<Date> values) {
            addCriterion("buy_time not in", values, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeBetween(Date value1, Date value2) {
            addCriterion("buy_time between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andBuyTimeNotBetween(Date value1, Date value2) {
            addCriterion("buy_time not between", value1, value2, "buyTime");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIsNull() {
            addCriterion("device_brand is null");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIsNotNull() {
            addCriterion("device_brand is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandEqualTo(String value) {
            addCriterion("device_brand =", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotEqualTo(String value) {
            addCriterion("device_brand <>", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandGreaterThan(String value) {
            addCriterion("device_brand >", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandGreaterThanOrEqualTo(String value) {
            addCriterion("device_brand >=", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLessThan(String value) {
            addCriterion("device_brand <", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLessThanOrEqualTo(String value) {
            addCriterion("device_brand <=", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandLike(String value) {
            addCriterion("device_brand like", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotLike(String value) {
            addCriterion("device_brand not like", value, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandIn(List<String> values) {
            addCriterion("device_brand in", values, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotIn(List<String> values) {
            addCriterion("device_brand not in", values, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandBetween(String value1, String value2) {
            addCriterion("device_brand between", value1, value2, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceBrandNotBetween(String value1, String value2) {
            addCriterion("device_brand not between", value1, value2, "deviceBrand");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIsNull() {
            addCriterion("device_version is null");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIsNotNull() {
            addCriterion("device_version is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionEqualTo(String value) {
            addCriterion("device_version =", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotEqualTo(String value) {
            addCriterion("device_version <>", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionGreaterThan(String value) {
            addCriterion("device_version >", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionGreaterThanOrEqualTo(String value) {
            addCriterion("device_version >=", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLessThan(String value) {
            addCriterion("device_version <", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLessThanOrEqualTo(String value) {
            addCriterion("device_version <=", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionLike(String value) {
            addCriterion("device_version like", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotLike(String value) {
            addCriterion("device_version not like", value, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionIn(List<String> values) {
            addCriterion("device_version in", values, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotIn(List<String> values) {
            addCriterion("device_version not in", values, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionBetween(String value1, String value2) {
            addCriterion("device_version between", value1, value2, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceVersionNotBetween(String value1, String value2) {
            addCriterion("device_version not between", value1, value2, "deviceVersion");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIsNull() {
            addCriterion("repair_type is null");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIsNotNull() {
            addCriterion("repair_type is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTypeEqualTo(String value) {
            addCriterion("repair_type =", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotEqualTo(String value) {
            addCriterion("repair_type <>", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeGreaterThan(String value) {
            addCriterion("repair_type >", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_type >=", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLessThan(String value) {
            addCriterion("repair_type <", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLessThanOrEqualTo(String value) {
            addCriterion("repair_type <=", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeLike(String value) {
            addCriterion("repair_type like", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotLike(String value) {
            addCriterion("repair_type not like", value, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeIn(List<String> values) {
            addCriterion("repair_type in", values, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotIn(List<String> values) {
            addCriterion("repair_type not in", values, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeBetween(String value1, String value2) {
            addCriterion("repair_type between", value1, value2, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairTypeNotBetween(String value1, String value2) {
            addCriterion("repair_type not between", value1, value2, "repairType");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionIsNull() {
            addCriterion("repair_instruction is null");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionIsNotNull() {
            addCriterion("repair_instruction is not null");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionEqualTo(String value) {
            addCriterion("repair_instruction =", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionNotEqualTo(String value) {
            addCriterion("repair_instruction <>", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionGreaterThan(String value) {
            addCriterion("repair_instruction >", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("repair_instruction >=", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionLessThan(String value) {
            addCriterion("repair_instruction <", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionLessThanOrEqualTo(String value) {
            addCriterion("repair_instruction <=", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionLike(String value) {
            addCriterion("repair_instruction like", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionNotLike(String value) {
            addCriterion("repair_instruction not like", value, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionIn(List<String> values) {
            addCriterion("repair_instruction in", values, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionNotIn(List<String> values) {
            addCriterion("repair_instruction not in", values, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionBetween(String value1, String value2) {
            addCriterion("repair_instruction between", value1, value2, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairInstructionNotBetween(String value1, String value2) {
            addCriterion("repair_instruction not between", value1, value2, "repairInstruction");
            return (Criteria) this;
        }

        public Criteria andRepairImageIsNull() {
            addCriterion("repair_image is null");
            return (Criteria) this;
        }

        public Criteria andRepairImageIsNotNull() {
            addCriterion("repair_image is not null");
            return (Criteria) this;
        }

        public Criteria andRepairImageEqualTo(String value) {
            addCriterion("repair_image =", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageNotEqualTo(String value) {
            addCriterion("repair_image <>", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageGreaterThan(String value) {
            addCriterion("repair_image >", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageGreaterThanOrEqualTo(String value) {
            addCriterion("repair_image >=", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageLessThan(String value) {
            addCriterion("repair_image <", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageLessThanOrEqualTo(String value) {
            addCriterion("repair_image <=", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageLike(String value) {
            addCriterion("repair_image like", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageNotLike(String value) {
            addCriterion("repair_image not like", value, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageIn(List<String> values) {
            addCriterion("repair_image in", values, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageNotIn(List<String> values) {
            addCriterion("repair_image not in", values, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageBetween(String value1, String value2) {
            addCriterion("repair_image between", value1, value2, "repairImage");
            return (Criteria) this;
        }

        public Criteria andRepairImageNotBetween(String value1, String value2) {
            addCriterion("repair_image not between", value1, value2, "repairImage");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusIsNull() {
            addCriterion("guarantee_status is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusIsNotNull() {
            addCriterion("guarantee_status is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusEqualTo(String value) {
            addCriterion("guarantee_status =", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusNotEqualTo(String value) {
            addCriterion("guarantee_status <>", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusGreaterThan(String value) {
            addCriterion("guarantee_status >", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_status >=", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusLessThan(String value) {
            addCriterion("guarantee_status <", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusLessThanOrEqualTo(String value) {
            addCriterion("guarantee_status <=", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusLike(String value) {
            addCriterion("guarantee_status like", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusNotLike(String value) {
            addCriterion("guarantee_status not like", value, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusIn(List<String> values) {
            addCriterion("guarantee_status in", values, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusNotIn(List<String> values) {
            addCriterion("guarantee_status not in", values, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusBetween(String value1, String value2) {
            addCriterion("guarantee_status between", value1, value2, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andGuaranteeStatusNotBetween(String value1, String value2) {
            addCriterion("guarantee_status not between", value1, value2, "guaranteeStatus");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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