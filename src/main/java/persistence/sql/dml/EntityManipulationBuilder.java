package persistence.sql.dml;

import persistence.sql.ddl.EntityMetadata;
import utils.CustomStringBuilder;

import static persistence.sql.dml.DataLanguage.*;

public class EntityManipulationBuilder {

    private final EntityMetadata entityMetadata;

    public EntityManipulationBuilder(Class<?> type) {
        this.entityMetadata = new EntityMetadata(type);
    }

    public String insert(Object entity) {
        return new CustomStringBuilder()
                .append(columnsClause(entity))
                .append(valueClause(entity))
                .toString();
    }

    private String columnsClause(Object entity) {
        // TODO 포캣 잡아주는 부분 리팩토링
        return new CustomStringBuilder()
                .append(INSERT.getName())
                .append(entityMetadata.getTableName())
                .appendWithoutSpace(LEFT_PARENTHESIS.getName())
                .appendWithoutSpace(entityMetadata.getColumnNames(entity))
                .append(RIGHT_PARENTHESIS.getName())
                .toStringWithoutSpace();

    }

    private String valueClause(Object entity) {
        return new CustomStringBuilder()
                .append(VALUES.getName())
                .appendWithoutSpace(LEFT_PARENTHESIS.getName())
                .appendWithoutSpace(entityMetadata.getValueFrom(entity))
                .appendWithoutSpace(RIGHT_PARENTHESIS.getName())
                .appendWithoutSpace(SEMICOLON.getName())
                .toStringWithoutSpace();
    }

}
