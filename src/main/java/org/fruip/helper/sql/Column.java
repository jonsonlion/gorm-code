package org.fruip.helper.sql;

import org.fruip.helper.util.GoTypeUtil;
import org.fruip.helper.util.StringUtil;

public class Column {

    private String name;
    private String type;
    private String defaultValue;
    private boolean isUnsigned;
    private boolean isNotNull;
    private String formatStr;
    private String typeFormatStr;
    private boolean isAutoIncrement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isUnsigned() {
        return isUnsigned;
    }

    public void setUnsigned(boolean unsigned) {
        isUnsigned = unsigned;
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setNotNull(boolean notNull) {
        isNotNull = notNull;
    }


    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }


    public String getFormatStr() {
        return formatStr;
    }

    public void setFormatStr(String formatStr) {
        this.formatStr = formatStr;
    }

    public String generateColumnStruc(boolean isPrimaryKey) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(StringUtil.camelString(this.name));
        sb.append(this.formatStr);
        sb.append(GoTypeUtil.Translate2GoType(this.type, this.isUnsigned));
        sb.append(this.typeFormatStr);
        sb.append("`gorm:\"type:").append(this.type.toUpperCase());
        sb.append(";");
        sb.append("column:").append(this.name);
        sb.append(";");
        if (isPrimaryKey) {
            sb.append("PRIMARY_KEY;");
        }
        if (this.isAutoIncrement()) {
            sb.append("AUTO_INCREMENT;");
        }
        if (this.isNotNull()) {
            sb.append("NOT NULL");
        }
        sb.append("\"`");
        return sb.toString();
    }

    public String getTypeFormatStr() {
        return typeFormatStr;
    }

    public void setTypeFormatStr(String typeFormatStr) {
        this.typeFormatStr = typeFormatStr;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", isUnsigned=" + isUnsigned +
                ", isNotNull=" + isNotNull +
                ", formatStr='" + formatStr + '\'' +
                ", typeFormatStr='" + typeFormatStr + '\'' +
                ", isAutoIncrement=" + isAutoIncrement +
                '}';
    }
}
