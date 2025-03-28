package net.ps.engine.condition.dynamic;


import java.util.Map;

public interface ConditionEval {
    boolean evaluate(Condition condition, Map<String, Object> inputData);
}

