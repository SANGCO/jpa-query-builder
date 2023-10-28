package persistence.sql.ddl;

import persistence.sql.ddl.dialect.Dialect;

import static utils.CustomStringBuilder.toCreateStatement;
import static utils.CustomStringBuilder.toDropStatement;

public class EntityDefinitionBuilder {

    private final EntityMetadata entityMetadata;

    public EntityDefinitionBuilder(Class<?> type, Dialect dialectParam) {
        this.entityMetadata = new EntityMetadata(type, dialectParam);
    }

    public String create() {
        return toCreateStatement(entityMetadata.getTableName(), entityMetadata.getColumnInfo());
    }

    public String drop() {
        return toDropStatement(entityMetadata.getTableName());
    }

}