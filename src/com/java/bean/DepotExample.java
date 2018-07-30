package com.java.bean;

import java.util.ArrayList;
import java.util.List;

public class DepotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DepotExample() {
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

        public Criteria andDepotNameIsNull() {
            addCriterion("depot_name is null");
            return (Criteria) this;
        }

        public Criteria andDepotNameIsNotNull() {
            addCriterion("depot_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepotNameEqualTo(String value) {
            addCriterion("depot_name =", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameNotEqualTo(String value) {
            addCriterion("depot_name <>", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameGreaterThan(String value) {
            addCriterion("depot_name >", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameGreaterThanOrEqualTo(String value) {
            addCriterion("depot_name >=", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameLessThan(String value) {
            addCriterion("depot_name <", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameLessThanOrEqualTo(String value) {
            addCriterion("depot_name <=", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameLike(String value) {
            addCriterion("depot_name like", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameNotLike(String value) {
            addCriterion("depot_name not like", value, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameIn(List<String> values) {
            addCriterion("depot_name in", values, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameNotIn(List<String> values) {
            addCriterion("depot_name not in", values, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameBetween(String value1, String value2) {
            addCriterion("depot_name between", value1, value2, "depotName");
            return (Criteria) this;
        }

        public Criteria andDepotNameNotBetween(String value1, String value2) {
            addCriterion("depot_name not between", value1, value2, "depotName");
            return (Criteria) this;
        }

        public Criteria andLocIsNull() {
            addCriterion("loc is null");
            return (Criteria) this;
        }

        public Criteria andLocIsNotNull() {
            addCriterion("loc is not null");
            return (Criteria) this;
        }

        public Criteria andLocEqualTo(String value) {
            addCriterion("loc =", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotEqualTo(String value) {
            addCriterion("loc <>", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThan(String value) {
            addCriterion("loc >", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThanOrEqualTo(String value) {
            addCriterion("loc >=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThan(String value) {
            addCriterion("loc <", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThanOrEqualTo(String value) {
            addCriterion("loc <=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLike(String value) {
            addCriterion("loc like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotLike(String value) {
            addCriterion("loc not like", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocIn(List<String> values) {
            addCriterion("loc in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotIn(List<String> values) {
            addCriterion("loc not in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocBetween(String value1, String value2) {
            addCriterion("loc between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotBetween(String value1, String value2) {
            addCriterion("loc not between", value1, value2, "loc");
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