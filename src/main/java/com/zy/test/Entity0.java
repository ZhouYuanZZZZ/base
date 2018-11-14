package com.zy.test;

public class Entity0 {

    private String val;

    public Entity0(String val) {
        this.val = val;
    }

    public Entity0() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Entity0) {
            Entity0 entity0 = (Entity0) obj;
            return entity0.val == this.val;
        }

        return false;
    }
}
