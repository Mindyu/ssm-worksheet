package com.java.bean;

import java.util.ArrayList;
import java.util.List;

public class DepotItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DepotItemExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andDepotnoIsNull() {
            addCriterion("depotno is null");
            return (Criteria) this;
        }

        public Criteria andDepotnoIsNotNull() {
            addCriterion("depotno is not null");
            return (Criteria) this;
        }

        public Criteria andDepotnoEqualTo(Integer value) {
            addCriterion("depotno =", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoNotEqualTo(Integer value) {
            addCriterion("depotno <>", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoGreaterThan(Integer value) {
            addCriterion("depotno >", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("depotno >=", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoLessThan(Integer value) {
            addCriterion("depotno <", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoLessThanOrEqualTo(Integer value) {
            addCriterion("depotno <=", value, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoIn(List<Integer> values) {
            addCriterion("depotno in", values, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoNotIn(List<Integer> values) {
            addCriterion("depotno not in", values, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoBetween(Integer value1, Integer value2) {
            addCriterion("depotno between", value1, value2, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotnoNotBetween(Integer value1, Integer value2) {
            addCriterion("depotno not between", value1, value2, "depotno");
            return (Criteria) this;
        }

        public Criteria andDepotItemIsNull() {
            addCriterion("depot_item is null");
            return (Criteria) this;
        }

        public Criteria andDepotItemIsNotNull() {
            addCriterion("depot_item is not null");
            return (Criteria) this;
        }

        public Criteria andDepotItemEqualTo(Integer value) {
            addCriterion("depot_item =", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemNotEqualTo(Integer value) {
            addCriterion("depot_item <>", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemGreaterThan(Integer value) {
            addCriterion("depot_item >", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("depot_item >=", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemLessThan(Integer value) {
            addCriterion("depot_item <", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemLessThanOrEqualTo(Integer value) {
            addCriterion("depot_item <=", value, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemIn(List<Integer> values) {
            addCriterion("depot_item in", values, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemNotIn(List<Integer> values) {
            addCriterion("depot_item not in", values, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemBetween(Integer value1, Integer value2) {
            addCriterion("depot_item between", value1, value2, "depotItem");
            return (Criteria) this;
        }

        public Criteria andDepotItemNotBetween(Integer value1, Integer value2) {
            addCriterion("depot_item not between", value1, value2, "depotItem");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("prod_id is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(Integer value) {
            addCriterion("prod_id =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Integer value) {
            addCriterion("prod_id <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Integer value) {
            addCriterion("prod_id >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prod_id >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Integer value) {
            addCriterion("prod_id <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Integer value) {
            addCriterion("prod_id <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Integer> values) {
            addCriterion("prod_id in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Integer> values) {
            addCriterion("prod_id not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Integer value1, Integer value2) {
            addCriterion("prod_id between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prod_id not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
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