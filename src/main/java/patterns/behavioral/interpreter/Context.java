package patterns.behavioral.interpreter;

import com.sun.rowset.internal.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Context {

    private static Map<String, List<Row>> tables = new HashMap<>();

    private String table;
    private String column;
    private Predicate<String> whereFilter;

    public void search() {
        if (whereFilter != null) {
            System.out.println("perform search in table " + table + " in column " + column + " with filter + " + whereFilter.toString());
        } else {
            System.out.println("perform search in table " + table + " in column " + column);
        }
    }

    public static void setTables(Map<String, List<Row>> tables) {
        Context.tables = tables;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setWhereFilter(Predicate<String> whereFilter) {
        this.whereFilter = whereFilter;
    }
}
