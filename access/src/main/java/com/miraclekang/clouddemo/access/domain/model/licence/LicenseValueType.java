package com.miraclekang.clouddemo.access.domain.model.licence;

public enum LicenseValueType {

    Enablement {
        public boolean isEnablement() {
            return true;
        }
    },

    Numberic {
        public boolean isNumberic() {
            return true;
        }
    },

    Date {
        public boolean isDate() {
            return true;
        }
    };

    public boolean isEnablement() {
        return false;
    }

    public boolean isNumberic() {
        return false;
    }

    public boolean isDate() {
        return false;
    }
}
