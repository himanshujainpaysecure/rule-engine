package net.ps.engine.condition.dynamic;

public class Condition {

    private String parameter;
    private String operator;
    private Object value;
    private String logicalOperator; // This will be used for AND, OR, NOT logic
    private Condition left; // For AND/OR/NOT combining multiple conditions
    private Condition right; // For AND/OR/NOT combining multiple conditions

    // Constructor for simple conditions
    public Condition(String parameter, String operator, Object value) {
        this.parameter = parameter;
        this.operator = operator;
        this.value = value;
        this.logicalOperator = null;  // No logical operator for simple conditions
        this.left = null;
        this.right = null;
    }

    // Constructor for complex conditions (AND, OR, NOT)
    public Condition(String logicalOperator, Condition left, Condition right) {
        this.logicalOperator = logicalOperator;
        this.left = left;
        this.right = right;
    }

    // Getters and Setters
    public String getParameter() {
        return parameter;
    }

    public String getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public Condition getLeft() {
        return left;
    }

    public Condition getRight() {
        return right;
    }
}
