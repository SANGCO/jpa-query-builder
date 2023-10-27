package persistence.sql.ddl.dialect;

import java.util.ArrayList;
import java.util.List;

public class ColumnSchemes {

    private List<ColumnScheme> columnSchemes;

    private ColumnSchemes() {
        columnSchemes = new ArrayList<>();
    }

    public static class Builder {
        private ColumnSchemes columnSchemes = new ColumnSchemes();

        public Builder addColumnScheme(String name, String value) {
            ColumnScheme columnScheme = new ColumnScheme(name, value);
            columnSchemes.columnSchemes.add(columnScheme);
            return this;
        }

        public ColumnSchemes build() {
            return columnSchemes;
        }
    }

    public List<ColumnScheme> getColumnSchemes() {
        return columnSchemes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getScheme(String name) {
        for (ColumnScheme columnScheme : columnSchemes) {
            if (columnScheme.getName().equals(name)) {
                return columnScheme.getValue();
            }
        }

        return null;
    }
    
}
