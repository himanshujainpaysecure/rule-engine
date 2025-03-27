package net.ps.engine.mapper;

import net.ps.engine.action.ActionType;

public class ActionMapper {
    private ActionType type; // Type of the action (e.g., "BlockCardAction", "SendEmailAction")

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }
}

